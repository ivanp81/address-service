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
import org.springframework.web.util.UriComponentsBuilder;

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
		
    @Before
    public void setUp() {
    	
    	addressRepository.deleteAll();
    	expectedResponse = createEntity();
    }
    
    public static AddressResponse createEntity() {
    	
    	AddressResponse.Builder addressResponse = new AddressResponse.Builder();
		return addressResponse
			  .withPostCode("XX200X")
			  .build();
    }

	@Test
	public void givenValidPostCode_whenGetFindUrl_thenStatusCodeIs200AndBodyIsExpectedResponse() throws Exception {

		addressRepository.save(expectedResponse);

		String validPostCode = "XX200X";
		
		String findUrl = UriComponentsBuilder
			     .fromPath("/find/{postcode}")
		 		 .buildAndExpand(validPostCode)
		 		 .toString();

		mvc.perform(get(findUrl))
		   .andExpect(status().isOk())
		   .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
		   .andExpect(content().string(TestUtil.convertObjectToJsonString(expectedResponse)));
	}
}