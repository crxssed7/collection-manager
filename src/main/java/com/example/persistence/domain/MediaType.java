package com.example.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class MediaType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String universalIdType;

	public MediaType(Long id, String name, String universalIdType) {
		super();
		this.id = id;
		this.name = name;
		this.universalIdType = universalIdType;
	}

	public MediaType() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUniversalIdType() {
		return universalIdType;
	}

	public void setUniversalIdType(String universalIdType) {
		this.universalIdType = universalIdType;
	}

}
