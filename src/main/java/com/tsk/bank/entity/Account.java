package com.tsk.bank.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Account extends AccountAudit {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long accountNb;
	
	private Double solde;

	private String fName;
	
	private String lName;

	private String address1;
	
	private String address2;
	
	private String phone;
	
	@Column(nullable = false, unique = true)
	private String cin;
	
	public Account() {
		super();
	}

	public Account(String fname, String lname, String address1, String address2	, String phone, String cin) {
		super();
		this.fName = fname;
		this.lName = lname;
		this.address1 = address1;
		this.address2 = address2;
		this.phone = phone;
		this.cin = cin;
	}

	public Long getAccountNb() {
		return accountNb;
	}

	public void setAccountNb(Long accountNb) {
		this.accountNb = accountNb;
	}

	public Double getSolde() {
		return solde;
	}

	public void setSolde(Double solde) {
		this.solde = solde;
	}

	

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	
	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}
	
	
	@Override
	public String toString() {
		return "Account [accountNb=" + accountNb + ", solde=" + solde + ", fname=" + fName + ", lname=" + lName
				+ ", address1=" + address1 +  ", address2=" + address2 + ", phone=" + phone + ", cin=" + cin + "]";
	}
	
	


}
