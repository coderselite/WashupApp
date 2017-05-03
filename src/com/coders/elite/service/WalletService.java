package com.coders.elite.service;

import java.util.List;

import com.coders.elite.bean.Wallet;
<<<<<<< HEAD
import com.coders.elite.model.WalletModel;
=======
>>>>>>> f1ba42b4627a0af0e654ee3da474451fe39822cf

public interface WalletService {
	public List<Wallet> getAllWallets();
	public Wallet getWallet(int id);
	public Wallet getWalletUser(int userId);
<<<<<<< HEAD
	public void addWallet(WalletModel wallet);
=======
	public void addWallet(Wallet wallet);
>>>>>>> f1ba42b4627a0af0e654ee3da474451fe39822cf
	public void deleteWallet(int id);
	public void updateWallet(Wallet wallet);
	public Wallet addWalletAmt(Wallet wallet);
	public Wallet subWalletAmt(Wallet wallet);
	public Wallet addReferalAmt(int userId);


}
