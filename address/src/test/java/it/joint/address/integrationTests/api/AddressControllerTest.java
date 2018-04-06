package it.joint.address.integrationTests.api;

import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import static org.mockito.MockitoAnnotations.initMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import it.joint.address.api.AddressController;
import it.joint.address.domain.model.AddressResponse;
import it.joint.address.domain.repository.AddressRepository;
import it.joint.address.util.TestUtil;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
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
	
    String validPostCode = "XX200X";
	
    @Before
    public void setUp() {
        initMocks(this);
        expectedResponse = new AddressResponse.Builder()
				  .withPostCode(validPostCode)
				  .withLatitude(51.39020538330078)
				  .withLongitude(-0.1320359706878662).build();
    }
        
    @Test
    public void givenValidPostCode_whenGetFindUrl_thenReturnAddressResponse() throws Exception {

    	doReturn(expectedResponse).when(addressRepository).findByPostCode(validPostCode);

        mvc.perform(get("/find/" + validPostCode))
            .andExpect(status().isOk())
            .andExpect(content().string(TestUtil.convertObjectToJsonString(expectedResponse)));
        
        verify(addressRepository).findByPostCode(validPostCode);
    }    
}