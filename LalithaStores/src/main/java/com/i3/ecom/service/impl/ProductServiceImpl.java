package com.i3.ecom.service.impl;

import static com.i3.ecom.utils.URLConstants.FAIL_STATUS;
import static com.i3.ecom.utils.URLConstants.SUCCESS_STATUS;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.i3.ecom.dao.ProductsDao;
import com.i3.ecom.dao.UserDao;
import com.i3.ecom.model.Category;
import com.i3.ecom.model.Product;
import com.i3.ecom.service.ProductService;
import com.i3.ecom.utils.ProductUtility;
import com.i3.ecom.utils.ProductValidation;
import com.i3.ecom.utils.ResponseMessage;

@Service(value = ProductServiceImpl.SERVICE_NAME)
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ProductServiceImpl implements ProductService {

	public static final String SERVICE_NAME = "ProductServiceImpl";

	@Autowired
	private ProductsDao productDao;

	@Autowired
	private UserDao userDao;

	@Override
	@Transactional
	public ResponseMessage addProduct(String productJson,
			final List<MultipartFile> imageFile) {
		String message = null;
		ResponseMessage responseMessage = null;
		Product product = Product.createProductEntity(productJson);

		try {
			ProductValidation.validateProduct(product);
			product.setCorosalImages(setCouroselImages(imageFile));
			product.setCreationDate(new Date());
			product.setModificationDate(new Date());
			message = productDao.addProduct(product);
			product = productDao.getProductByName(product.getProductName());
			long pId = product.getProductId();
			long cId = product.getCategoryId();
			if (imageFile != null) {
				saveProductImage(imageFile, pId, cId,
						product.getImageFileName());
			}
			responseMessage = new ResponseMessage(SUCCESS_STATUS, message);
		} catch (Exception e) {
			message = e.getMessage();
			responseMessage = new ResponseMessage(FAIL_STATUS, message);
		}
		return responseMessage;
	}

	private String setCouroselImages(List<MultipartFile> imageFile) {
		StringBuffer string = new StringBuffer();
		if (imageFile != null) {
			if (imageFile.size() == 1) {
				string.append(imageFile.get(0).getOriginalFilename());
			} else {
				for (MultipartFile multiPartFile : imageFile) {
					string.append(multiPartFile.getOriginalFilename() + ",");
				}

				string.deleteCharAt(string.lastIndexOf(","));
			}
		}

		return string.toString();
	}

	@Override
	@Transactional
	public ResponseMessage addCategory(Category category) {
		String message = null;
		ResponseMessage response = null;
		try {
			ProductValidation.validateCategory(category);
			category.setCreationDate(new Date());
			category.setModificationDate(new Date());
			message = productDao.addCategory(category);
			category = productDao.getCategoryByName(category.getCategoryName());
			ProductUtility.createCategoryDirectory(category);
			response = new ResponseMessage(SUCCESS_STATUS, message);
		} catch (Exception ex) {
			message = ex.getMessage();
			response = new ResponseMessage(FAIL_STATUS, message);
		}
		return response;
	}

	private void saveProductImage(final List<MultipartFile> imageFiles,
			final long pId, final long cId, String defaultImageFileName)
			throws Exception {
		try {
			String basePath = null;
			basePath = ProductUtility.createProductDirectory(cId, pId);
			for (MultipartFile multipartFile : imageFiles) {
				String fileName = multipartFile.getOriginalFilename();
				File file = new File(basePath, fileName);
				multipartFile.transferTo(file);
				if (fileName.equals(defaultImageFileName)) {
					BufferedImage image = ImageIO.read(file);
					ImageIO.write(image, "jpg",
							new File(file.getAbsolutePath()));
					String[] tempFileName = file.getName().split("\\.");
					String thumbnailFile = tempFileName[0] + "_thumbnail."
							+ tempFileName[1];
					File thumbnailImage = new File(file.getParent() + "/"
							+ thumbnailFile);
					FileUtils.copyFile(file, thumbnailImage);
					saveThumbnailForImage(thumbnailImage);
				}

			}

		} catch (Exception e) {
			throw new Exception("Problem occured while copying images");
		}

	}

	private void saveThumbnailForImage(File file) throws Exception {
		try {
			BufferedImage sourceImage = ImageIO.read(file);
			int width = sourceImage.getWidth();
			int height = sourceImage.getHeight();

			BufferedImage outputImage = new BufferedImage(188, 250,
					sourceImage.getType());

			Graphics2D g2d = outputImage.createGraphics();
			g2d.drawImage(sourceImage, 0, 0, 188, 250, null);
			g2d.dispose();

			ImageIO.write(outputImage, "jpg", new File(file.getAbsolutePath()));

		} catch (IOException e) {
			throw new Exception("Problem Occured while saving image");
		}
	}

	@Override
	@Transactional
	public ResponseMessage getAllCategories() {
		List<Category> categories = new ArrayList<Category>();
		ResponseMessage response = null;
		try {
			categories = productDao.getAllCategories();
			response = new ResponseMessage(SUCCESS_STATUS, null);
			response.setData(categories);
		} catch (Exception ex) {
			response = new ResponseMessage(FAIL_STATUS, ex.getMessage());
		}
		return response;
	}

	@Override
	@Transactional
	public ResponseMessage getProductsByCategory(final String categoryId) {
		long category = Long.parseLong(categoryId);
		List<Product> products = new ArrayList<Product>();
		ResponseMessage response = null;
		try {
			products = productDao.getAllProductsByCategory(category);
			for (Product product : products) {
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				String format = formatter.format(product.getCreationDate().getTime());
				product.setDateAdded(format);
			}
			response = new ResponseMessage(SUCCESS_STATUS, null);
			response.setData(products);
		} catch (Exception ex) {
			response = new ResponseMessage(FAIL_STATUS, ex.getMessage());
		}
		return response;
	}

	@Override
	public ResponseMessage removeCategory(final long categoryId) {
		ResponseMessage response = null;
		try {
			productDao.deleteAllProduct(categoryId);
			ProductUtility.removeCategoryDirectory(categoryId);
			String deleteCategory = productDao.deleteCategory(categoryId);
			response = new ResponseMessage(SUCCESS_STATUS, deleteCategory);
		} catch (Exception ex) {
			response = new ResponseMessage(FAIL_STATUS, ex.getMessage());
		}
		return response;
	}

	@Override
	public ResponseMessage removeProduct(Product product) {
		ResponseMessage message = null;
		try {
			long cId = product.getCategoryId();
			long pId = product.getProductId();
			ProductUtility.removeProductDirectory(cId, pId);
			String deleteProduct = productDao.deleteProduct(pId);
			message = new ResponseMessage(SUCCESS_STATUS, deleteProduct);
		} catch (Exception ex) {
			message = new ResponseMessage(FAIL_STATUS, ex.getMessage());
		}
		return message;
	}

	/*
	 * @Override public ResponseMessage removeAllProduct(String categoryId) {
	 * 
	 * }
	 */

	@Override
	@Transactional
	public ResponseMessage updateProduct(Product product) {
		ResponseMessage response = null;
		String message = null;
		try {
			Product productToEdit = productDao.getProductById(product
					.getProductId());
			productToEdit = convertProduct(productToEdit, product);
			ProductValidation.validateProduct(productToEdit);
			message = productDao.updateProduct(productToEdit);
			response = new ResponseMessage(SUCCESS_STATUS, message);
		} catch (Exception ex) {
			message = ex.getMessage();
			response = new ResponseMessage(FAIL_STATUS, message);
		}
		return response;
	}

	private Product convertProduct(Product productToEdit, Product product) {
		productToEdit.setDescription(product.getDescription());
		productToEdit.setPrice(product.getPrice());
		productToEdit.setProductActive(product.isProductActive());
		productToEdit.setProductLocation(product.getProductLocation());
		productToEdit.setProductName(product.getProductName());
		productToEdit.setQuantityWeight(product.getQuantityWeight());
		productToEdit.setModificationDate(new Date());
		productToEdit.setQuantityStock(product.getQuantityStock());
		return productToEdit;
	}

	@Override
	public ResponseMessage updateCategory(Category category) {
		ResponseMessage response = null;
		String message = null;
		try {
			Category categoryToEdit = productDao.getCategoryById(category
					.getCategoryId());
			categoryToEdit = convertCategory(categoryToEdit, category);
			ProductValidation.validateCategory(categoryToEdit);
			message = productDao.updateCategory(categoryToEdit);
			response = new ResponseMessage(SUCCESS_STATUS, message);
		} catch (Exception ex) {
			message = ex.getMessage();
			response = new ResponseMessage(FAIL_STATUS, message);
		}
		return response;
	}

	private Category convertCategory(Category categoryToEdit, Category category) {
		categoryToEdit.setDescription(category.getDescription());
		categoryToEdit.setCategoryName(category.getCategoryName());
		categoryToEdit.setModificationDate(new Date());
		categoryToEdit.setAddedBy(category.getAddedBy());
		return categoryToEdit;
	}

}
