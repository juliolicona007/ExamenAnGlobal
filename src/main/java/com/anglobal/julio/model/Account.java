package com.anglobal.julio.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "accounts")
public class Account implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_account")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAccount;

	private Integer numberAccount;
	
	private BigInteger balance;
	
	private Integer owner;
	
	private LocalDate createdAt;

	public Long getIdAccount() {
		return idAccount;
	}

	public void setIdAccount(Long idAccount) {
		this.idAccount = idAccount;
	}

	public Integer getNumberAccount() {
		return numberAccount;
	}

	public void setNumberAccount(Integer numberAccount) {
		this.numberAccount = numberAccount;
	}

	public BigInteger getBalance() {
		return balance;
	}

	public void setBalance(BigInteger balance) {
		this.balance = balance;
	}

	public Integer getOwner() {
		return owner;
	}

	public void setOwner(Integer owner) {
		this.owner = owner;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}
	
}
