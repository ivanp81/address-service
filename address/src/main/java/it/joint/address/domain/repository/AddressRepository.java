package it.joint.address.domain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.joint.address.domain.model.AddressResponse;

@Repository
public interface AddressRepository extends MongoRepository<AddressResponse, String> {

    AddressResponse findByPostCode(String postCode);

}
