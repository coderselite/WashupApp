package com.coders.elite.model;

public class WalletModel {
	
	private int wallet_amt;
	
	private int user_id;
	
	public WalletModel(){
		super();
	}

	public WalletModel(int wallet_amt, int user_id) {
		super();
		this.wallet_amt = wallet_amt;
		this.user_id = user_id;
	}

	public int getWallet_amt() {
		return wallet_amt;
	}

	public void setWallet_amt(int wallet_amt) {
		this.wallet_amt = wallet_amt;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	

}
