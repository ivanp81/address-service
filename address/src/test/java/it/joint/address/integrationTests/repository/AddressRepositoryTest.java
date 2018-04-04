package it.joint.address.integrationTests.repository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.After;
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
	
    @Before
    public void setUp() {
    	addressRepository.deleteAll();
    	expectedResponse = createEntity();
    }
    
    @After
    public void tearDown() {
    	
    }
    
    public static AddressResponse createEntity() {
    	
    	AddressResponse.Builder addressResponse = new AddressResponse.Builder();
		
		return addressResponse
			  .withPostCode("XX200X")
			  .build();
    }

	@Test
	public void givenValidPostCode_whenFindByPostCode_thenActualResponseIsExpectedResponse() throws Exception {

		String validPostCode = "XX200X";
		
		addressRepository.save(expectedResponse);
		
		AddressResponse actualResponse = addressRepository.findByPostCode(validPostCode);
		assertThat(actualResponse, is(expectedResponse));
		
		addressRepository.deleteAll();
	}

}
