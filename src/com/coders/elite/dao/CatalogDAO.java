package com.coders.elite.dao;

import java.util.List;

import com.coders.elite.bean.Catalog;
public interface CatalogDAO {
	
	public List<Catalog> getAllCatalogs();
	 
	 public void addCatalog(Catalog cat);
	 
	 public void updateCatalog(Catalog cat);
	 
	 public void deleteCatalog(int id);

}
