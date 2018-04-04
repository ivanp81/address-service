package it.joint.address.integrationTests.api;

import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.util.UriComponentsBuilder;

import it.joint.address.api.AddressController;
import it.joint.address.domain.model.AddressResponse;
import it.joint.address.domain.repository.AddressRepository;
import it.joint.address.util.TestUtil;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AddressController.class)
@ActiveProfiles("test")
public class AddressControllerTest {
	
	@Autowired
    private MockMvc mvc;

	@MockBean
    private AddressRepository addressRepository;
    
    private AddressResponse expectedResponse;
	
    @Before
    public void setUp() {

        MockitoAnnotations.initMocks(this);
    	
        expectedResponse = createEntity();
    	
        given(addressRepository.findByPostCode(expectedResponse.getPostCode()))
       .willReturn(expectedResponse);
    }
    
    public static AddressResponse createEntity() {
    	
    	AddressResponse.Builder addressResponse = new AddressResponse.Builder();
		
		return addressResponse
			  .withPostCode("XX200X")
			  .build();
    }
    
    @Test
    public void givenValidPostCode_whenGetFindUrl_thenStatusCodeIsOkAndContentIsExpectedResponse() throws Exception {

    	String validPostCode = "XX200X";
		
        String findUrl = UriComponentsBuilder
        			     .fromPath("/find/{postcode}")
				 		 .buildAndExpand(validPostCode)
				 		 .toString();

        mvc.perform(get(findUrl))
            .andExpect(status().isOk())
            .andExpect(content().string(TestUtil.convertObjectToJsonString(expectedResponse)));
    }    
}