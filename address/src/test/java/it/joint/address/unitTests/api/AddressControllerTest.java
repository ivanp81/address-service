package it.joint.address.unitTests.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import it.joint.address.api.AddressController;
import it.joint.address.domain.model.AddressResponse;
import it.joint.address.domain.repository.AddressRepository;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.MockitoAnnotations.initMocks;

public class AddressControllerTest {

	private AddressController addressController;
   
    @Mock
    private AddressRepository addressRepository;
    
    private AddressResponse expectedResponse;
    
    @Before
    public void setUp() throws Exception {
        initMocks(this);
        addressController = new AddressController(addressRepository);
        expectedResponse = mock(AddressResponse.class);
    }
    
    @Test
    public void givenValidPostCode_whenFindByPostCosde_thenActualResponseEqualToExpectedResponse() throws Exception {

        String validPostCode = "XX200X";
        
        given(addressRepository.findByPostCode(validPostCode))
       .willReturn(expectedResponse);
        
        AddressResponse actualResponse = addressController.findByPostCode(validPostCode);
        
        assertThat(actualResponse, equalTo(expectedResponse));
    }
}