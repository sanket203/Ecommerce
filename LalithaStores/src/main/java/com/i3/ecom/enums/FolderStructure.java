package com.i3.ecom.enums;

public enum FolderStructure {
  
	BASE_FOLDER { 
	  @Override public String path() { 
		  return "C:/LS-Home"; 
      } 
    }, 
    PRODUCT_IMAGES { 
    	@Override public String path() { 
    		return BASE_FOLDER.path()+"/ProductImages/"; 
    	} 
    }; 
    public abstract String path(); 
}
