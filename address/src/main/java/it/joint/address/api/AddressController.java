package it.joint.address.api;

import it.joint.address.domain.model.AddressResponse;
import it.joint.address.domain.repository.AddressRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddressController {

    private AddressRepository addressRepository;

    @Autowired
    public AddressController(AddressRepository addressRepository) {
	this.addressRepository = addressRepository;
    }

    @RequestMapping(path = "/find/{postCode}", method = RequestMethod.GET)
    public AddressResponse findByPostCode(@PathVariable String postCode) {
	return addressRepository.findByPostCode(postCode);
    }
}
