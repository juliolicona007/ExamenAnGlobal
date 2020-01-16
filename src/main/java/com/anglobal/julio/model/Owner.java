package com.anglobal.julio.model;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "owners")
public class Owner implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_owner")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idOwner;
	
	private String name;
	
	private String lastName;
	
	private LocalDate createdAt;

	public Long getIdOwner() {
		return idOwner;
	}

	public void setIdOwner(Long idOwner) {
		this.idOwner = idOwner;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}
	
}
