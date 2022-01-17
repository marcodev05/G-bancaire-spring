package com.tsk.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.tsk.bank.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
	
	public Boolean existsByCin(String cin);
}
