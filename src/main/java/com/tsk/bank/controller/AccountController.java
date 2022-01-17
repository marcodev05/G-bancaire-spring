package com.tsk.bank.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tsk.bank.entity.Account;
import com.tsk.bank.service.account.AccountService;
@CrossOrigin("*")
@RestController
public class AccountController {
	
	private static final String PUBLIC = "/api/v1/accounts";

	@Autowired
	AccountService service;
	

	@GetMapping(PUBLIC)
	public ResponseEntity<List<Account>> getAllAccount(){
		List<Account> c = service.getAllAccounts();
		return new ResponseEntity<>(c, HttpStatus.OK);
	}
	

	
	
	@PostMapping(PUBLIC + "/add")
	public ResponseEntity<Account> addAccount(@RequestBody Account account) {
		Account c = service.create(account);
		return new ResponseEntity<>(c, HttpStatus.CREATED);
	}
	
	
	
	
	@PutMapping(PUBLIC + "/update/{id}")
	public ResponseEntity<Account> updateAccount(@RequestBody Account account, @PathVariable("id") Long id) {
		Account c = service.update(id, account);
		return ResponseEntity.ok().body(c);
	}
	
	
	
	@DeleteMapping(PUBLIC + "/delete/{id}")
	public Map<String, Boolean> deleteAccount(@PathVariable("id") Long id) {
		service.delete(id);
		Map<String, Boolean> response = new HashMap<String, Boolean>();
		response.put("delete", Boolean.TRUE);
		return response;
	}
	
}
