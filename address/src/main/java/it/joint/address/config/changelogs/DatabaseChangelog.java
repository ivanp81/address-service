package it.joint.address.config.changelogs;

import org.springframework.data.mongodb.core.MongoTemplate;

import com.github.mongobee.changeset.ChangeLog;
import com.github.mongobee.changeset.ChangeSet;

import it.joint.address.domain.model.AddressResponse;

@ChangeLog
public class DatabaseChangelog {

	@ChangeSet(order = "001", id = "dummyInitialData", author = "testAuthor")
	public void dummyInitialData(MongoTemplate mongoTemplate) {
	  
		AddressResponse address = new AddressResponse();
		address.setPostCode("XX200X");
		address.setLatitude(51.39020538330078);
		address.setLongitude(-0.1320359706878662);
		
		mongoTemplate.save(address);
	}
}
