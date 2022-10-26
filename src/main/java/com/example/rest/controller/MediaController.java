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

import com.example.persistence.domain.Media;
import com.example.persistence.domain.MediaType;
import com.example.rest.dto.MediaDto;
import com.example.rest.dto.MediaTypeDto;
import com.example.service.MediaService;

@RestController
@RequestMapping(value = "/media")
public class MediaController {
	@Autowired
	private MediaService service;

	public MediaController(MediaService service) {
		super();
		this.service = service;
	}
	
	//Below are the CRUD methods for Media
	
	//Reads all Media in the database
	@GetMapping("/read")
	public List<MediaDto> readAll() {
		return this.service.readMedia();
	}
	
	//Read a specific Media from the database
	@GetMapping("/read/{id}")
	public MediaDto readById(@PathVariable Long id) {
		return this.service.readById(id);
	}
	
	//Adds new Media to the database
	@PostMapping("/create")
	@ResponseStatus(code = HttpStatus.CREATED)
	public MediaDto create(@RequestBody Media media)
	{
		return this.service.addMedia(media);
	}
	
	//Updates Media if its in the database
	@PutMapping("/update/{id}")
	public MediaDto update(@PathVariable Long id,@RequestBody Media media)
	{
		return this.service.updateMedia(id, media);
	}
	
	//Deletes Media if its in the database
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id)
	{
		this.service.deleteMedia(id);
	}
}
