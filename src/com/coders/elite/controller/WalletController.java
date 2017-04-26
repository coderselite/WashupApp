package com.coders.elite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.coders.elite.bean.Wallet;
import com.coders.elite.model.WalletModel;
import com.coders.elite.service.WalletService;



@RestController
public class WalletController {
	
	@Autowired
	WalletService walletService;
	
	@RequestMapping(value ="/getAllWallet", method = RequestMethod.GET, headers ="Accept=application/json")
	public List<Wallet> getAllWallet(){
		List<Wallet> listofWallets =  walletService.getAllWallets();
		return listofWallets;
	}
	
	@RequestMapping(value="/getWallet/id/{id}", method= RequestMethod.GET, headers="Accpet=application/json")
	public Wallet getWallet(@PathVariable Integer id){
		return walletService.getWallet(id);
	}
	
	@RequestMapping(value="/getWalletUser/id/{userId}", method =RequestMethod.GET, headers="Accept=application/json")
	public Wallet getWalletUser(@PathVariable Integer userId){
		return walletService.getWalletUser(userId);
	}
	
	@RequestMapping(value="/addWallet", method =RequestMethod.POST, headers="Accept=application/json")
	public void addWallet(@RequestBody WalletModel wallet){
		System.out.println("Inside Wallet Add Controller");
		walletService.addWallet(wallet);
	}
	
	@RequestMapping(value="/updateWallet", method=RequestMethod.PUT, headers="Accpet=application/json")
	public void updateWallet(@RequestBody Wallet wallet){
		walletService.updateWallet(wallet);
	}
	
	@RequestMapping(value="/addWalletAmt", method=RequestMethod.PUT, headers="Accpet=application/json")
	public Wallet addWalletAmt(@RequestBody Wallet wallet){
		return walletService.addWalletAmt(wallet);
	}
	
	@RequestMapping(value="/subWalletAmt", method=RequestMethod.PUT, headers="Accept=application/json")
	public Wallet subWalletAmt(@RequestBody Wallet wallet){
		return walletService.subWalletAmt(wallet);
	}
	
	@RequestMapping(value="/deleteWallet/id/{id}", method=RequestMethod.DELETE, headers="ccept=application/json")
	public void deleteWallet(@PathVariable Integer id){
		walletService.deleteWallet(id);
	}
}
