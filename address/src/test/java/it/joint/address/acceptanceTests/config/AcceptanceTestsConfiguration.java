package it.joint.address.acceptanceTests.config;

import java.net.URISyntaxException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.util.UriComponentsBuilder;

@Configuration
public class AcceptanceTestsConfiguration {
	
	private final static String ADDRESS_URL = System.getProperty("acceptance.address.url", "http://localhost:8080");
	
	@Bean
	public UriComponentsBuilder addressBaseUrl() throws URISyntaxException {
		return UriComponentsBuilder.fromUriString(ADDRESS_URL);
	}
}
