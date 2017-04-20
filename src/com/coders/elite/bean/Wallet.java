package com.coders.elite.bean;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Proxy;


@Entity
@Table(name="WALLET")  @Proxy(lazy = false)
public class Wallet implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="wallet_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer walletId;
	
	@Column(name="wallet_amt")
	private Integer walletAmt;
	
	@OneToOne
	@JoinColumn (name="user_id")
	private Users user;
	
	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Wallet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Wallet(int id,int wAmt){
		super();
		this.walletId = id;
		this.walletAmt = wAmt;
	}
	
	public Wallet(Integer walletAmt) {
		super();
		this.walletAmt = walletAmt;

	}

	public int getWalletId(){
		return walletId;
	}
	
	public void setWalletId(int id){
		this.walletId=id;
	}
	
	public Integer getWalletAmt(){
		return walletAmt;
	}
	
	public void setWalletAmt(Integer wAmt){
		this.walletAmt = wAmt;
	}
}
