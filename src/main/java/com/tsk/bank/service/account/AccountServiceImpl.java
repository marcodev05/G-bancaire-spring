package com.tsk.bank.service.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tsk.bank.entity.Account;
import com.tsk.bank.exception.FormatDataInvalidException;
import com.tsk.bank.exception.ResourceNotFoundException;
import com.tsk.bank.repository.AccountRepository;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository accountRepo;
	
	
	
	@Override
	public Account create(Account account) {
		account.setSolde(0.0);
		if(this.isExistsCin(account.getCin())) throw new FormatDataInvalidException("cette cin est déjà inscrit à un compte");
		return accountRepo.save(account);
	}

	
	
	@Override
	public Account update(Long id, Account account) {
		Account c = this.getAccountById(id);
		c.setfName(account.getfName());
		c.setlName(account.getlName());
		c.setCin(account.getCin());
		c.setAddress1(account.getAddress1());
		c.setAddress2(account.getAddress2());
		c.setPhone(account.getPhone()); 
		//if(this.isExistsCin(account.getCin())) throw new FormatDataInvalidException("cette cin est déjà inscrit à un compte");
		return accountRepo.save(c);
	}

	
	
	@Override
	public Account getAccountById(Long id) {
		return accountRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Le compte est introuvable"));
	}

	
	
	@Override
	public void delete(Long accountNb) {
		Account c = this.getAccountById(accountNb);
		accountRepo.delete(c);

	}



	@Override
	public List<Account> getAllAccounts() {
		return accountRepo.findAll();
	}
	
	
	
	private Boolean isExistsCin(String cin) {
		return accountRepo.existsByCin(cin);
	}

}
