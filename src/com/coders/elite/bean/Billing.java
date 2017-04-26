package com.coders.elite.bean;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name="Billing")@Proxy(lazy=false)
public class Billing implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="bill_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer bill_id;
	
	public Billing(int bill_amt, String status, Orders order, Wallet wallet) {
		super();
		this.bill_amt = bill_amt;
		this.status = status;
	}

	public Billing(Integer bill_id, int bill_amt, String status) {
		super();
		this.bill_id = bill_id;
		this.bill_amt = bill_amt;
		this.status = status;
	}

	public Billing() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getBill_id() {
		return bill_id;
	}

	public void setBill_id(Integer bill_id) {
		this.bill_id = bill_id;
	}

	public int getBill_amt() {
		return bill_amt;
	}

	public void setBill_amt(int bill_amt) {
		this.bill_amt = bill_amt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}

	@Column(name="bill_amt")
	private int bill_amt;
	
	@Column (name="status")
	private String status;
	
	@OneToOne
	@JoinColumn(name="order_id")
	public Orders order;
	
	@ManyToOne
	@JoinColumn(name="wallet_id")
	public Wallet wallet;
	

}
