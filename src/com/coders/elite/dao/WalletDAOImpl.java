package com.coders.elite.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coders.elite.bean.Wallet;

@Repository
public class WalletDAOImpl implements WalletDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private void setSessionFactory(SessionFactory sf){
		sessionFactory =sf;
	}

	@SuppressWarnings("unchecked")
	public List<Wallet> getAllWallet() {
		Session session = this.sessionFactory.getCurrentSession();
		List <Wallet>listWallets = session.createQuery("from Wallet").list();
		return listWallets;
	}

	@Override
	public Wallet getWallet(int id) {
		Session session =this.sessionFactory.getCurrentSession();
		Wallet wallet = (Wallet)session.load(Wallet.class, new Integer(id));
		return wallet;
	}

	@Override
	public Wallet getWalletUser(int userId) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Wallet> wallet = (List<Wallet>) session.createQuery("from Wallet W where W.user.user_id= :userId").setParameter("userId", userId).list();
		if(wallet.size()>0){
			return wallet.get(0);
		}
		return null;
	}

	@Override
	public Wallet addWallet(Wallet wallet) {
		System.out.println("Inside WalletDAOImpl");
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(wallet);
		return null;
	}

	@Override
	public void deleteWallet(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Wallet w = (Wallet)session.load(Wallet.class, new Integer(id));
		if(null!= w){
			session.delete(w);
		}				
	}

	@Override
	public void updateWallet(Wallet wallet) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(wallet);		
	}



}
