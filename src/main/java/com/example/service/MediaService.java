package com.example.service;

import com.example.exception.MediaNotFoundException;
import com.example.exception.MediaTypeNotFoundException;
import com.example.persistence.domain.Media;
import com.example.persistence.domain.MediaType;
import com.example.persistence.repository.MediaRepository;
import com.example.rest.dto.MediaDto;
import com.example.rest.dto.MediaTypeDto;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MediaService {
	@Autowired
	private MediaRepository repo;
	@Autowired
	private ModelMapper mapper;

	public MediaService(MediaRepository repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}
	
	private MediaDto mapToDTO(Media media) {
        return this.mapper.map(media, MediaDto.class);
    }
	
	//CRUD methods
	
	public List<MediaDto> readMedia() {
		return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	}
	
    public MediaDto readById(Long id) {
        Media found = this.repo.findById(id).orElseThrow(MediaNotFoundException::new);
        return this.mapToDTO(found);
    }
    
	public MediaDto addMedia(Media media) {
		Media saved = this.repo.save(media);
		return this.mapToDTO(saved);
	}
	
	public MediaDto updateMedia(Long mediaId, Media media) {
		//Find the existing record in the database
		Media existing = this.repo.findById(mediaId).orElseThrow(MediaNotFoundException::new);

		existing.setName(media.getName());
		existing.setCreators(media.getCreators());
		existing.setDescription(media.getDescription());
		existing.setImage(media.getImage());
		existing.setMediaType(media.getMediaType());
		existing.setUniversalId(media.getUniversalId());
		existing.setCopies(media.getCopies());
		existing.setPrice(media.getPrice());
		existing.setNotes(media.getNotes());

		Media newMedia = this.repo.save(existing);

		return this.mapToDTO(newMedia);
	}
	
	public boolean deleteMedia(Long mediaId) {
		this.repo.deleteById(mediaId);
		// Check if the record was deleted.
		boolean exists = this.repo.existsById(mediaId);
		return !exists;
	}
}
