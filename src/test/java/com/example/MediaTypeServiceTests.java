package com.example;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.persistence.domain.MediaType;
import com.example.persistence.repository.MediaTypeRepository;
import com.example.rest.dto.MediaTypeDto;
import com.example.service.MediaTypeService;

@SpringBootTest
public class MediaTypeServiceTests {
	// This file tests the service layer for MediaType
	@MockBean
	private MediaTypeRepository repo;
	@Autowired
	private MediaTypeService service;

	// Test the read by id functionality
	@Test
	void testReadById() {
		final Long id = 1L;
		final MediaType mediaType = new MediaType();
		given(repo.findById(id)).willReturn(Optional.of(mediaType));
		final MediaTypeDto dto = service.readById(id);
		assertThat(dto).isNotNull();
	}

	// Test to see if it correctly retrieves the MediaType data
	@Test
	void testReadMediaTypes() {
		List<MediaType> mediaTypeList = new ArrayList<>();
		mediaTypeList.add(new MediaType(1L, "Book", "ISBN"));
		mediaTypeList.add(new MediaType(2L, "Movie", "EAN"));
		mediaTypeList.add(new MediaType(3L, "Video Game", "EAN"));
		mediaTypeList.add(new MediaType(4L, "Music", "EAN"));
		given(repo.findAll()).willReturn(mediaTypeList);
		List<MediaTypeDto> dto = service.readMediaTypes();
		assertThat(dto).usingRecursiveComparison().isEqualTo(mediaTypeList);
	}

	// Test for create
	@Test
	void testAddMediaType() throws Exception {
		final MediaType mediaType = new MediaType(1L, "Book", "ISBN");
		given(this.repo.save(mediaType)).willReturn(mediaType);
		MediaTypeDto dto = this.service.addMediaType(mediaType);
		assertThat(dto).usingRecursiveComparison().isEqualTo(mediaType);
	}

	// Test for delete
	@Test
	void testDeleteMediaType() {
		final Long id = 1L;
		service.deleteMediaType(id);
		service.deleteMediaType(id);
		verify(repo, times(2)).deleteById(id);
	}

	// Test for updating mediatype
	@Test
	void testUpdateMedia() {
		final MediaType TEST_SAVED_MEDIATYPE = new MediaType(1L, "Book", "ISBN");
		given(repo.save(any(MediaType.class))).willReturn(TEST_SAVED_MEDIATYPE);
		MediaType mediaType = repo.save(TEST_SAVED_MEDIATYPE);
		assertThat(mediaType).isNotNull();
	}
}
