package com.coders.elite.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.coders.elite.bean.Catalog;
import com.coders.elite.dao.CatalogDAO;

@Service
public class CatalogServiceImpl implements CatalogService{

	@Autowired
	CatalogDAO catalogDao;
	
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public List<Catalog> getAllCatalogs() {

		return catalogDao.getAllCatalogs();
	}

	@Override
	@Transactional
	public void addCatalog(Catalog cat) {
		catalogDao.addCatalog(cat);
		
	}

	@Override
	@Transactional
	public void updateCatalog(Catalog cat) {
		catalogDao.updateCatalog(cat);
		
	}

	@Override
	@Transactional
	public void deleteCatalog(int id) {
		catalogDao.deleteCatalog(id);
		
	}
	
	@Override
	@Transactional
	public Catalog getCatalog(int id){
		return catalogDao.getCatalog(id);
	}

}
