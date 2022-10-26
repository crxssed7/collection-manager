package com.example.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Media {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String creators;
	private String description;
	private String image;
	@ManyToOne(targetEntity = MediaType.class)
	@JsonBackReference
	private MediaType mediaType;
	private String universalId;
	@Min(1)
	private int copies;
	private float price;
	private String notes;
	
	public Media() {
		super();
	}

	public Media(Long id, String name, String creators, String description, String image,
			MediaType mediaType, String universalId, @Min(1) int copies, float price, String notes) {
		super();
		this.id = id;
		this.name = name;
		this.creators = creators;
		this.description = description;
		this.image = image;
		this.mediaType = mediaType;
		this.universalId = universalId;
		this.copies = copies;
		this.price = price;
		this.notes = notes;
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

	public String getCreators() {
		return creators;
	}

	public void setCreators(String creators) {
		this.creators = creators;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public MediaType getMediaType() {
		return mediaType;
	}

	public void setMediaType(MediaType mediaType) {
		this.mediaType = mediaType;
	}

	public String getUniversalId() {
		return universalId;
	}

	public void setUniversalId(String universalId) {
		this.universalId = universalId;
	}

	public int getCopies() {
		return copies;
	}

	public void setCopies(int copies) {
		this.copies = copies;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}
