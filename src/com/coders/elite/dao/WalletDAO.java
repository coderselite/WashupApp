package com.coders.elite.dao;

import java.util.List;

import com.coders.elite.bean.Wallet;

public interface WalletDAO {
	public List<Wallet> getAllWallet();
	public Wallet getWallet(int id);
	public Wallet getWalletUser(int uid);
	public Wallet addWallet(Wallet wallet);
	public void deleteWallet(int id);
	public void updateWallet(Wallet wallet);


}
