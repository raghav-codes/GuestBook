package com.example.guestBook;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;

import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@AutoConfigureRestDocs
class GuestBookApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@Autowired
	GuestBookRepository guestBookRepository;

	@Autowired
	ObjectMapper objectMapper;

	@Test
	void addGuestTest() throws Exception {

		GuestDto guestDto = new GuestDto();

		mockMvc.perform(get("/guests"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("length()").value(0));




	}

	@Test
	void postGuestTest( ) throws Exception {
			GuestDto guestDto1 = new GuestDto("Zxander","Test");
			mockMvc.perform(post("/guests")
					.content(objectMapper.writeValueAsString(guestDto1))
					.contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isCreated())
					.andDo(document("AddGuests"));

							mockMvc.perform(get("/guests"))
					.andExpect(status().isOk())
					.andExpect(jsonPath("length()").value(1))
					.andExpect(jsonPath("[0].guestName").value("Zxander"))
					.andExpect(jsonPath("[0].guestComment").value("Test"))
					.andDo(document("Guests", responseFields(
							fieldWithPath("[0].guestName").description("Zxander"),
							fieldWithPath("[0].guestComment").description("Test"))));


	}

}
