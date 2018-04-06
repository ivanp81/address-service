package it.joint.address.componentTests;

import it.joint.address.domain.model.AddressResponse;
import it.joint.address.domain.repository.AddressRepository;
import it.joint.address.util.TestUtil;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class AddressComponentTest {

	@Autowired
    private MockMvc mvc;
	
	@Autowired
	private AddressRepository addressRepository;
		
	private AddressResponse expectedResponse;
		
	private String validPostCode = "XX200X";
	
    @Before
    public void setUp() {
    	
    	expectedResponse = new AddressResponse.Builder()
				  .withPostCode(validPostCode)
				  .withLatitude(51.39020538330078)
				  .withLongitude(-0.1320359706878662).build();
  	
    	addressRepository.deleteAll();
    	addressRepository.save(expectedResponse);
    }
    
	@Test
	public void givenValidPostCode_whenGetFindUrl_thenReturnAddressResponse() throws Exception {

		mvc.perform(get("/find/" + validPostCode))
		   .andExpect(status().isOk())
		   .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
		   .andExpect(content().string(TestUtil.convertObjectToJsonString(expectedResponse)));
	}
}