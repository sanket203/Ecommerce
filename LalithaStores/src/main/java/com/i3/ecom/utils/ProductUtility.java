package com.i3.ecom.utils;

import static com.i3.ecom.enums.FolderStructure.PRODUCT_IMAGES;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import com.i3.ecom.model.Category;

public class ProductUtility {

	public static void createCategoryDirectory(final Category category) throws Exception{
		if(category == null){
			throw new Exception("Category Not Found");
		}
		File file = new File(PRODUCT_IMAGES.path()+category.getCategoryId());
		if(!file.exists()){
			file.mkdir();
		}
	}
	
	public static String createProductDirectory(final long cId, final long pId) {
		String basePath = PRODUCT_IMAGES.path()+cId+"/"+pId;
		File file = new File(basePath);
		if(!file.exists()){
			file.mkdirs();
		}
		return file.getAbsolutePath();
	}
	
	public static void removeProductDirectory(final long cId, final long pId) throws Exception {
		String basePath = PRODUCT_IMAGES.path()+cId+"/"+pId;
		File file = new File(basePath);
		if(file.exists()){
			try {
				FileUtils.deleteDirectory(file);
			} catch (IOException e) {
				throw new Exception("Error while deleting product directory");
			}
		}
	}
	
	public static void removeCategoryDirectory(final long cId) throws Exception {
		String basePath = PRODUCT_IMAGES.path()+cId;
		File file = new File(basePath);
		if(file.exists()){
			try {
				FileUtils.deleteDirectory(file);
			} catch (IOException e) {
				throw new Exception("Error while deleting category directory");
			}
		}
	}
	
}
