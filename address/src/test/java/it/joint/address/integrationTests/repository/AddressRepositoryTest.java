package it.joint.address.integrationTests.repository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import it.joint.address.domain.model.AddressResponse;
import it.joint.address.domain.repository.AddressRepository;

@RunWith(SpringRunner.class)
@DataMongoTest
@ActiveProfiles("test")
@DirtiesContext(classMode = ClassMode.AFTER_CLASS)
public class AddressRepositoryTest {

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
	public void givenValidPostCode_whenFindByPostCode_thenActualResponseIsExpectedResponse() throws Exception {
	
		AddressResponse actualResponse = addressRepository.findByPostCode(validPostCode);
		assertThat(actualResponse, is(expectedResponse));
	}
}
