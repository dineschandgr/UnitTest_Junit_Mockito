package io.springboot.starter.hello;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
class HelloControllerTest {

	
	private MockMvc mockMvc;
	
	@InjectMocks
	private HelloController helloController;
	
	@BeforeEach
	public void setUp() throws Exception{
		HelloController helloController = new HelloController();
		mockMvc = MockMvcBuilders.standaloneSetup(helloController).build();
	}
	
	@Test
	void testHelloWorld() throws Exception {
		 mockMvc.perform(MockMvcRequestBuilders.get("/hello"))		 
		 		.andExpect(status().isOk())
		 		.andExpect(content().string("Hello World"));
	}
	
	@Test
	void testHelloWorldJson() throws Exception {
		 mockMvc.perform(MockMvcRequestBuilders.get("/json")
				.accept(MediaType.APPLICATION_JSON))
		 			.andExpect(status().isOk())
		 			.andExpect(jsonPath("$.title",Matchers.is("Hello Title")))
		 			.andExpect(jsonPath("$.value",Matchers.is("Hello Message")));
	}

}
