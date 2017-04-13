package com.coders.elite.service;

import java.util.List;

import com.coders.elite.bean.Catalog;

public interface CatalogService {
	
	public List<Catalog> getAllCatalogs();
	 
	 public void addCatalog(Catalog cat);
	 
	 public void updateCatalog(Catalog cat);
	 
	 public void deleteCatalog(int id);

}
