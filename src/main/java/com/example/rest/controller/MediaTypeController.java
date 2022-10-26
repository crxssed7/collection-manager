package com.example.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.persistence.domain.MediaType;
import com.example.rest.dto.MediaTypeDto;
import com.example.service.MediaTypeService;

@RestController
@RequestMapping(value = "/mediatype")
public class MediaTypeController {
	@Autowired
	private MediaTypeService service;

	public MediaTypeController(MediaTypeService service) {
		super();
		this.service = service;
	}
	
	// Below are all the CRUD methods for Media Types.
	
	//Reads all Media Types in the database
	@GetMapping("/read")
	public List<MediaTypeDto> readAll() {
		return this.service.readMediaTypes();
	}
	
	//Reads a specific Media Type from the database
	@GetMapping("/read/{id}")
	public MediaTypeDto readById(@PathVariable Long id) {
		return this.service.readById(id);
	}
	
	//Adds a new Media Type to the database
	@PostMapping("/create")
	@ResponseStatus(code = HttpStatus.CREATED)
	public MediaTypeDto create(@RequestBody MediaType mediaType)
	{
		return this.service.addMediaType(mediaType);
	}
	
	//Updates a Media Type if its in the database
	@PutMapping("/update/{id}")
	public MediaTypeDto update(@PathVariable Long id,@RequestBody MediaType mediaType)
	{
		return this.service.updateMediaType(id, mediaType);
	}
	
	//Deletes a Media Type if its in the database
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id)
	{
		this.service.deleteMediaType(id);
	}
}
