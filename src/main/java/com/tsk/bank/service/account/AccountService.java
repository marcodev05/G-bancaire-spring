package com.tsk.bank.service.account;

import java.util.List;
import java.util.Optional;

import com.tsk.bank.entity.Account;

public interface AccountService {

	public Account create(Account account);
	public Account update(Long id, Account account);
	public Account getAccountById(Long id);
	public List<Account> getAllAccounts();
	public void delete(Long accountNb);
}
