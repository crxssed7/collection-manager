package com.example.rest.dto;

public class MediaTypeDto {
	private Long id;
	private String name;
	private String universalIdType;

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
