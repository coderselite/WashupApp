package com.coders.elite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.coders.elite.bean.Catalog;
import com.coders.elite.service.CatalogService;

//@CrossOrigin(origins="http://localhost:8100", maxAge=4800, allowCredentials="False") 
@RestController
public class CatalogController {

	@Autowired
	CatalogService catalogService;
	
	/*
	 * Service to getAllCatalogs from the catalog table.
	 */
	@RequestMapping(value = "/getAllCatalogs", method = RequestMethod.GET, headers= "Accept=application/json")
	public List <Catalog> getCatalogs(){
		return catalogService.getAllCatalogs();
	}
	
	/*
	 * Service to add a catalog to the table.
	 */
	 @RequestMapping(value = "/addCatalog", method = RequestMethod.POST, headers = "Accept=application/json")
	 public void addCatalog(@RequestBody Catalog cat) { 
		 catalogService.addCatalog(cat);
	  
	 }
	 
	 /*
	  * Service to update an exisiting catalog in the table.
	  */
	 @RequestMapping(value = "/updateCatalog", method = RequestMethod.PUT, headers = "Accept=application/json")
	 public void updateCatalog(@RequestBody Catalog cat) {
		 catalogService.updateCatalog(cat);
	 }
	 
	 /*
	  * Service to delete a catalog specified by the catalog_id.
	  */
	 @RequestMapping(value = "/deleteCatalog/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	 public void deleteCatalog(@PathVariable("id") int id) {
		 catalogService.deleteCatalog(id);  
	 }
	 
	/*
	 * Service to getCatalogs for a specific catalog_id.
	 */
	 @RequestMapping(value = "/getCatalog/{id}", method = RequestMethod.GET, headers= "Accept=application/json")
	public Catalog getCatalog(int id){
		 return catalogService.getCatalog(id);
	}
		
}
