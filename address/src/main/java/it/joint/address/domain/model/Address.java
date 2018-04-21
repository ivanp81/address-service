package it.joint.address.domain.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "addresses")
public class Address {

    @Id
    private String id;

    private String line1;

    private String line2;

    private String line3;

    private String line4;

    private String locality;

    private String city;

    private String country;

    public String getId() {
	return id;
    }

    public void setId(String id) {
	this.id = id;
    }

    public String getLine1() {
	return line1;
    }

    public void setLine1(String line1) {
	this.line1 = line1;
    }

    public String getLine2() {
	return line2;
    }

    public void setLine2(String line2) {
	this.line2 = line2;
    }

    public String getLine3() {
	return line3;
    }

    public void setLine3(String line3) {
	this.line3 = line3;
    }

    public String getLine4() {
	return line4;
    }

    public void setLine4(String line4) {
	this.line4 = line4;
    }

    public String getLocality() {
	return locality;
    }

    public void setLocality(String locality) {
	this.locality = locality;
    }

    public String getCity() {
	return city;
    }

    public void setCity(String city) {
	this.city = city;
    }

    public String getCountry() {
	return country;
    }

    public void setCountry(String country) {
	this.country = country;
    }
}
