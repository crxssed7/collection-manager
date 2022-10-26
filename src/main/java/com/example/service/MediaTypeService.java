package com.example.service;

import com.example.exception.MediaTypeNotFoundException;
import com.example.persistence.domain.MediaType;
import com.example.persistence.repository.MediaTypeRepository;
import com.example.rest.dto.MediaTypeDto;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MediaTypeService {
	@Autowired
	private MediaTypeRepository repo;
	@Autowired
	private ModelMapper mapper;

	public MediaTypeService(MediaTypeRepository repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}

	private MediaTypeDto mapToDTO(MediaType mediaType) {
		return this.mapper.map(mediaType, MediaTypeDto.class);
	}

	// All the CRUD methods needed.

	public List<MediaTypeDto> readMediaTypes() {
		return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	}

	public MediaTypeDto readById(Long id) {
		MediaType found = this.repo.findById(id).orElseThrow(MediaTypeNotFoundException::new);
		return this.mapToDTO(found);
	}

	public MediaTypeDto addMediaType(MediaType mediaType) {
		MediaType saved = this.repo.save(mediaType);
		return this.mapToDTO(saved);
	}

	public MediaTypeDto updateMediaType(Long mediaTypeId, MediaType mediaType) {
		//Find the existing record in the database
		MediaType existing = this.repo.findById(mediaTypeId).orElseThrow(MediaTypeNotFoundException::new);

		existing.setName(mediaType.getName());
		existing.setUniversalIdType(mediaType.getUniversalIdType());

		MediaType newMediaType = this.repo.save(existing);

		return this.mapToDTO(newMediaType);
	}

	public boolean deleteMediaType(Long mediaTypeId) {
		this.repo.deleteById(mediaTypeId);
		// Check if the record was deleted.
		boolean exists = this.repo.existsById(mediaTypeId);
		return !exists;
	}
}
