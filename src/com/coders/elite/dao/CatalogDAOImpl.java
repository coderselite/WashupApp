package com.coders.elite.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coders.elite.bean.Catalog;

@Repository
public class CatalogDAOImpl implements CatalogDAO {

	 @Autowired
	 private SessionFactory sessionFactory;
	 
	 public void setSessionFactory(SessionFactory sf) {
	  this.sessionFactory = sf;
	 }
	 
	@SuppressWarnings("unchecked")
	@Override
	public List<Catalog> getAllCatalogs() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Catalog> list= session.createQuery("from Catalog").list();
		if(list.size() > 0){
			return list;
		}
		return null;
	}

	@Override
	public void addCatalog(Catalog cat) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(cat);

	}

	@Override
	public void updateCatalog(Catalog cat) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(cat);
	}

	@Override
	public void deleteCatalog(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Catalog cat = (Catalog) session.load(Catalog.class, new Integer(id));
		if(cat != null){
			session.delete(cat);
		}

	}
	

}
