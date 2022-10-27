package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.persistence.domain.Media;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class MediaIntegrationTests {
	@Autowired
	private MockMvc mock;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	public void testCreateMedia() throws Exception {
		Media media = new Media(1L, "Ready Player One", "Ernest Cline", "Blurb of book", "https://google.com/", null,
				"1234556", 1, 1.99f, "This is the notes");
		//Send a mock request to the create media endpoint
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.POST, "/media/create");
		mockRequest.contentType(MediaType.APPLICATION_JSON);
		mockRequest.content(this.objectMapper.writeValueAsString(media));
		mockRequest.accept(MediaType.APPLICATION_JSON);
		ResultMatcher matchStatus = MockMvcResultMatchers.status().isCreated();
		this.mock.perform(mockRequest).andExpect(matchStatus);
	}
}
