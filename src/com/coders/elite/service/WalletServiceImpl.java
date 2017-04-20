package com.coders.elite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coders.elite.bean.Wallet;
import com.coders.elite.dao.WalletDAOImpl;

@Service("WalletService")
public class WalletServiceImpl implements WalletService{
	
	@Autowired
	WalletDAOImpl walletDAO;
	
	private Wallet wallet;
	
	@Transactional
	@Override
	public List<Wallet> getAllWallets() {
		return walletDAO.getAllWallet();
	}

	@Transactional
	@Override
	public Wallet getWallet(int id) {
		return walletDAO.getWallet(id);
	}

	@Transactional
	@Override
	public Wallet getWalletUser(int userId) {
		return walletDAO.getWalletUser(userId);
	}

	@Transactional
	@Override
	public void addWallet(Wallet wallet) {
		System.out.println("Inside the Service add Wallet");
		walletDAO.addWallet(wallet);
	}

	@Transactional
	@Override
	public void deleteWallet(int id) {
		walletDAO.deleteWallet(id);
		
	}

	@Transactional
	@Override
	public void updateWallet(Wallet wallet) {
		walletDAO.updateWallet(wallet);
		
	}

	@Transactional
	@Override
	public Wallet addWalletAmt(Wallet wallet) {
		Wallet w = walletDAO.getWallet(wallet.getUser().getId());
		Integer amt = w.getWalletAmt();
		amt = amt + wallet.getWalletAmt();
		w.setWalletAmt(amt);
		walletDAO.updateWallet(w);
		return w;
	}

	@Transactional
	@Override
	public Wallet subWalletAmt(Wallet wallet) {
		Wallet w = walletDAO.getWallet(wallet.getUser().getId());
		Integer amt = w.getWalletAmt();
		amt = amt - wallet.getWalletAmt();
		w.setWalletAmt(amt);
		walletDAO.updateWallet(w);
		return w;
	}

	@Override
	public Wallet addReferalAmt(int userId) {
		Wallet w = walletDAO.getWalletUser(userId);
		Integer amt = w.getWalletAmt();
		amt = amt + 15;
		w.setWalletAmt(amt);
		walletDAO.updateWallet(w);
		return w;
		
	}

}
