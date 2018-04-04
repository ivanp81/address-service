package it.joint.address.config.changelogs;

import org.springframework.data.mongodb.core.MongoTemplate;

import com.github.mongobee.changeset.ChangeLog;
import com.github.mongobee.changeset.ChangeSet;

import it.joint.address.domain.model.AddressResponse;

@ChangeLog
public class DatabaseChangelog {

	@ChangeSet(order = "001", id = "dummyDataSave", author = "testAuthor")
	public void someChange5(MongoTemplate mongoTemplate) {
	  
		AddressResponse address = new AddressResponse();
		address.setPostCode("XX200X");
		address.setLatitude("12345");
		address.setLongitude("-12345");
		
		mongoTemplate.save(address);
	}
}
