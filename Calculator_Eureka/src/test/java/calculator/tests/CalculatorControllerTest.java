package calculator.tests;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest
public class CalculatorControllerTest 
{
	 @Autowired
	  private MockMvc mockMvc;
	 	 
	 @Test
	 public void testCalculatorController() throws Exception
	 {
		 mockMvc.perform(get("/add?x=5&y=4")
		 .contentType(MediaType.APPLICATION_JSON))
		 .andExpect(status().isOk());
		 
	 }
	 @Test
	 public void testJsonResult() throws Exception
	 {
		 RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
	                "/add?x=9&y=78").accept(
	                MediaType.APPLICATION_JSON);

	        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

	        //System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&"+result.getResponse().getContentAsString());
	        JSONAssert.assertEquals("87", result.getResponse()
	                .getContentAsString(), false);
	 }
	 	 
}
