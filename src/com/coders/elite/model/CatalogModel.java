package com.coders.elite.model;

public class CatalogModel {

	private int catalog_id;
	
	private int quantity;

	public CatalogModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CatalogModel(int catalog_id, int quantity) {
		super();
		this.catalog_id = catalog_id;
		this.quantity = quantity;
	}

	public int getCatalog_id() {
		return catalog_id;
	}

	public void setCatalog_id(int catalog_id) {
		this.catalog_id = catalog_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
