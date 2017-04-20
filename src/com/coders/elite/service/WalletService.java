package com.coders.elite.service;

import java.util.List;

import com.coders.elite.bean.Wallet;

public interface WalletService {
	public List<Wallet> getAllWallets();
	public Wallet getWallet(int id);
	public Wallet getWalletUser(int userId);
	public void addWallet(Wallet wallet);
	public void deleteWallet(int id);
	public void updateWallet(Wallet wallet);
	public Wallet addWalletAmt(Wallet wallet);
	public Wallet subWalletAmt(Wallet wallet);
	public Wallet addReferalAmt(int userId);


}
