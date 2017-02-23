package com.i3.ecom.service.impl;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.i3.ecom.dao.ProductDetailsDao;
import com.i3.ecom.dto.ProductDto;
import com.i3.ecom.model.Product;
import com.i3.ecom.service.ProductDetailsService;
import com.i3.ecom.utils.ResponseMessage;
import com.i3.ecom.utils.URLConstants;
@Service(value= ProductDetailsServiceImpl.SERVICE_NAME)
@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
public class ProductDetailsServiceImpl implements ProductDetailsService {
	
	@Autowired
	ProductDetailsDao productDao;
	
	public static final String SERVICE_NAME = "ProductDetailsServiceImpl";
	
	public ResponseMessage getAllCategories() {
		
		 final String uri = "http://localhost:8080/lalithaAdmin/getCategories.htm";
		
		 RestTemplate restTemplate = new RestTemplate();
		 ResponseMessage result = restTemplate.getForObject(uri,ResponseMessage.class);
		 
		// new Gson().toJson(result).toString();
		 return result;
		
	}

	public ResponseMessage getProductsByCategory(String categoryId) {
		ResponseMessage response = null;
		long category = Long.parseLong(categoryId);
		try {
			List<Product> product  = productDao.getAllProductsByCategory(category);
			List<ProductDto> productList = getProductDtoList(product);
			response = new ResponseMessage(URLConstants.SUCCESS_STATUS,null);
			response.setData(productList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			response = new ResponseMessage(URLConstants.FAIL_STATUS,e.getMessage());
		}
		 return response;
		 
		 
	}

	private List<ProductDto> getProductDtoList(List<Product> product) {
		List<ProductDto> list = new ArrayList<ProductDto>();
		
		for (Product prod : product) {

			ProductDto productDto = new ProductDto();
			productDto.setProductId(prod.getProductId());
			productDto.setProductName(prod.getProductName());
			productDto.setProductDescription(prod.getDescription());
			productDto.setPrice(Double.parseDouble(prod.getPrice()));
			productDto.setCategoryId(prod.getCategoryId());
			productDto.setProductActive(prod.isProductActive());
			String imageUrl  = getLocalIpAddress()+productDto.getCategoryId()+"/"+productDto.getProductId()+"/"+prod.getImageFileName();
			productDto.setImageUrl(imageUrl);
			list.add(productDto);
			
		}
		return list;
	}

	@Override
	public ResponseMessage getSingleProduct(String categoryId, String productId) {
		ResponseMessage response = null;
		try {
			Product product = productDao.getProductById(Long.parseLong(productId));
			ProductDto productDto = new ProductDto();
			productDto.setProductId(product.getProductId());
			productDto.setProductName(product.getProductName());
			productDto.setProductDescription(product.getDescription());
			productDto.setPrice(Double.parseDouble(product.getPrice()));
			productDto.setCategoryId(product.getCategoryId());
			productDto.setProductActive(product.isProductActive());
			String imageUrl  = getLocalIpAddress()+productDto.getCategoryId()+"/"+productDto.getProductId()+"/"+product.getImageFileName();
			productDto.setImageUrl(imageUrl);
			response = new ResponseMessage(URLConstants.SUCCESS_STATUS, null);
			response.setData(productDto);
		} catch (Exception e) {
			
			response = new ResponseMessage(URLConstants.FAIL_STATUS, e.getMessage());
		}
		
		return response;
	}
	
	private String  getLocalIpAddress(){
		InetAddress ip = null;
		  try {

			ip = InetAddress.getLocalHost();
			System.out.println("Current IP address : " + ip.getHostAddress());
			
			String ipAdd = ip.getHostAddress();

		  } catch (UnknownHostException e) {

			e.printStackTrace();

		  }
		  
		  return "http://"+ip.getHostAddress()+":8080/files/";
		  
		  

	}
		

}
