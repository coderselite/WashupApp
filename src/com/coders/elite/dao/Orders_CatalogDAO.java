package com.coders.elite.dao;

import java.util.List;

import com.coders.elite.bean.Orders_Catalog;

public interface Orders_CatalogDAO {

	public List <Orders_Catalog> getOrders(int order_id);
	
	public void addOrders_Catalog(Orders_Catalog oc);
	
	public void updateOrders_Catalog(Orders_Catalog oc);
	
	public void deleteOrders_Catalog(int id);
}
