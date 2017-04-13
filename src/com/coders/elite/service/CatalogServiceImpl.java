package com.coders.elite.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coders.elite.bean.Catalog;
import com.coders.elite.dao.CatalogDAO;

@Service
public class CatalogServiceImpl implements CatalogService{

	@Autowired
	CatalogDAO catalogDao;
	
	
	@Override
	@Transactional
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

}
