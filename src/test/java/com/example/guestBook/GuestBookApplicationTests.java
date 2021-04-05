package com.example.guestBook;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class GuestBookApplicationTests {

	@Autowired
	MockMvc mockmvc;
	@Test
	void addGuestTest() throws Exception {

		GuestDto guestDto = new GuestDto();

		mockmvc.perform(get("/guests"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("length()").value(1))
				.andExpect(jsonPath("[0].name").value("Zxander"))
				.andExpect(jsonPath("[0].comment").value("Galvanize"));
	}

}
