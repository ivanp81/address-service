package it.joint.address.domain.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "addresses")
public class AddressResponse {

	@Id
	private String id;

	private String postCode;
	
	private String latitude;
	
	private String longitude;
	
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

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
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
		
		if (!this.id.equals(other.id))
			return false;

		return true;
	}

	public int hashCode() {
		return id.hashCode();
	}

	public static class Builder {

		private String id;
		private String postCode;
    	private String latitude;
    	private String longitude;
    	private List<Address> addresses;

        public Builder() {

        }

        public Builder withId(String id){
            this.id = id;
            return this; 
        }
        
        public Builder withPostCode(String postCode){
            this.postCode = postCode;
            return this; 
        }
        
        public Builder withLatitude(String latitude){
            this.latitude = latitude;
            return this; 
        }

        public Builder withLongitude(String longitude){
            this.longitude = longitude;
            return this; 
        }
        
        public Builder withAddresses(List<Address> addresses){
            this.addresses = addresses;
            return this; 
        }

        public AddressResponse build(){

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
