package it.joint.address.acceptanceTests;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.util.UriComponentsBuilder;

import it.joint.address.acceptanceTests.config.AcceptanceTestsConfiguration;

import static io.restassured.RestAssured.when;
import static org.hamcrest.core.Is.is;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { AcceptanceTestsConfiguration.class })
public class AddressE2ETest {

	@Autowired
	private UriComponentsBuilder addressBaseUrl;
	
	@Test
	public void givenValidPostCode_whenGetFindUrl_thenStatusCodeIs200() {

		String validPostCode = "XX200X";
		
		String findUrl = addressBaseUrl.path("/find/{postCode}")
								   		  .buildAndExpand(validPostCode)
								   		  .toString();
		
		when()
		.get(findUrl)
		.then()
		.statusCode(is(200));
	}
}
