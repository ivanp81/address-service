package it.joint.address.domain.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
@Document(collection = "addresses")
public class AddressResponse implements Serializable {

    @Id
    private String id;

    private String postCode;

    private Double latitude;

    private Double longitude;

    private List<Address> addresses;

    public String getId() {
	return id;
    }

    public void setId(String id) {
	this.id = id;
    }

    public String getPostCode() {
	return postCode;
    }

    public void setPostCode(String postCode) {
	this.postCode = postCode;
    }

    public Double getLatitude() {
	return latitude;
    }

    public void setLatitude(Double latitude) {
	this.latitude = latitude;
    }

    public Double getLongitude() {
	return longitude;
    }

    public void setLongitude(Double longitude) {
	this.longitude = longitude;
    }

    public List<Address> getAddresses() {
	return addresses;
    }

    public void setAddresses(List<Address> addresses) {
	this.addresses = addresses;
    }

    public boolean equals(Object o) {

	if (o == null)
	    return false;
	if (!(o instanceof AddressResponse))
	    return false;

	AddressResponse other = (AddressResponse) o;

	if (!this.postCode.equals(other.postCode))
	    return false;

	return true;
    }

    public int hashCode() {
	return postCode.hashCode();
    }

    public static class Builder {

	private String id;
	private String postCode;
	private Double latitude;
	private Double longitude;
	private List<Address> addresses;

	public Builder() {

	}

	public Builder withId(String id) {
	    this.id = id;
	    return this;
	}

	public Builder withPostCode(String postCode) {
	    this.postCode = postCode;
	    return this;
	}

	public Builder withLatitude(Double latitude) {
	    this.latitude = latitude;
	    return this;
	}

	public Builder withLongitude(Double longitude) {
	    this.longitude = longitude;
	    return this;
	}

	public Builder withAddresses(List<Address> addresses) {
	    this.addresses = addresses;
	    return this;
	}

	public AddressResponse build() {

	    AddressResponse addressResponse = new AddressResponse();

	    addressResponse.id = this.id;
	    addressResponse.postCode = this.postCode;
	    addressResponse.latitude = this.latitude;
	    addressResponse.longitude = this.longitude;
	    addressResponse.addresses = this.addresses;

	    return addressResponse;

	}
    }
}
