package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.persistence.domain.Media;
import com.example.persistence.repository.MediaRepository;
import com.example.rest.dto.MediaDto;
import com.example.service.MediaService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class MediaServiceTests {
	//This file tests the service layer for Media
	@MockBean
	private MediaRepository repo;
	@Autowired
	private MediaService service;
		
	//Test the read by id functionality
	@Test
	void testReadById()
	{
		final Long id = 1L;
		final Media media = new Media();
		given(repo.findById(id)).willReturn(Optional.of(media));
		final MediaDto dto = service.readById(id);
		assertThat(dto).isNotNull();
	}
	
	//Test to see if it correctly retrieves the Media data
	@Test
	void testReadMedia()
	{
		List<Media> mediaList = new ArrayList<>();
		mediaList.add(new Media(1L, "Ready Player One", "Ernest Cline", "Blurb of book", "https://google.com/", null, "1234556", 1, 1.99f, "This is the notes"));
		mediaList.add(new Media(2L, "Armada: A Novel", "Ernest Cline", "Blurb of book", "https://armada.com/", null, "47465467", 6, 11.99f, "Very cool sci-fi book!"));
		given(repo.findAll()).willReturn(mediaList);
		List<MediaDto> dto = service.readMedia();
		assertThat(dto).usingRecursiveComparison().isEqualTo(mediaList);
	}
	
	//Test for create
	@Test
	void testAddMedia() throws Exception
	{
		final Media media = new Media(null, "The Hunger Games", "Suzanne Collins", "Blurb of book", "https://thg.com/hunger.jpg", null, "56645752", 8, 20.99f, "Very cool dystopian book!");
		given(this.repo.save(media)).willReturn(media);
		MediaDto dto = this.service.addMedia(media);
		assertThat(dto).usingRecursiveComparison().isEqualTo(media);
	}
	
	//Test for delete
	@Test
	void testDeleteMedia()
	{
		final Long id = 1L;
		service.deleteMedia(id);
		service.deleteMedia(id);
		verify(repo, times(2)).deleteById(id);
	}
	
	//Test for updating media
	@Test
	void testUpdateMedia()
	{
		final Media TEST_SAVED_MEDIA = new Media(1L, "Ready Player One", "Ernest Cline", "Blurb of book", "https://google.com/", null, "1234556", 1, 1.99f, "This is the notes");
		given(repo.save(any(Media.class))).willReturn(TEST_SAVED_MEDIA);
		Media media = repo.save(TEST_SAVED_MEDIA);
		assertThat(media).isNotNull();
	}
}
