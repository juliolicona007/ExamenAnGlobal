package com.anglobal.julio.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transactions")
public class Transaction implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_transaction")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTransaction;
	
	private Integer fromAccount;
	
	private Integer toAccount;
	
	private BigInteger amount;
	
	private LocalDateTime sentAt;

	public Long getIdTransaction() {
		return idTransaction;
	}

	public void setIdTransaction(Long idTransaction) {
		this.idTransaction = idTransaction;
	}

	public Integer getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(Integer fromAccount) {
		this.fromAccount = fromAccount;
	}

	public Integer getToAccount() {
		return toAccount;
	}

	public void setToAccount(Integer toAccount) {
		this.toAccount = toAccount;
	}

	public BigInteger getAmount() {
		return amount;
	}

	public void setAmount(BigInteger amount) {
		this.amount = amount;
	}

	public LocalDateTime getSentAt() {
		return sentAt;
	}

	public void setSentAt(LocalDateTime sentAt) {
		this.sentAt = sentAt;
	}

}
