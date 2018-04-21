package it.joint.address.unitTests.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import it.joint.address.api.AddressController;
import it.joint.address.domain.model.AddressResponse;
import it.joint.address.domain.repository.AddressRepository;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class AddressControllerTest {

    private AddressController addressController;

    @Mock
    private AddressRepository addressRepository;

    private String validPostCode = "XX200X";
    private AddressResponse expectedResponse;

    @Before
    public void setUp() {
	initMocks(this);
	addressController = new AddressController(addressRepository);
	expectedResponse = new AddressResponse.Builder().withPostCode(validPostCode).withLatitude(51.39020538330078)
		.withLongitude(-0.1320359706878662).build();
    }

    @Test
    public void givenValidPostCode_whenFindByPostCosde_thenReturnAddressResponse() throws Exception {

	doReturn(expectedResponse).when(addressRepository).findByPostCode(validPostCode);

	AddressResponse addressResponse = addressController.findByPostCode(validPostCode);

	verify(addressRepository).findByPostCode(validPostCode);
	assertThat(addressResponse, equalTo(expectedResponse));
    }
}