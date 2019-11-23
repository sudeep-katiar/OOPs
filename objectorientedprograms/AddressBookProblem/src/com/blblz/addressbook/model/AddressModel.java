package com.blblz.addressbook.model;

public class AddressModel {
	private String FirstName;
	private String LastName;
	private String Address;
	private String City;
	private String State;
	private String Pincode;
	private String Phone;
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getPincode() {
		return Pincode;
	}
	public void setPincode(String pincode) {
		Pincode = pincode;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	@Override
	public String toString() {
		return "AddressModel [FirstName=" + FirstName + ", LastName=" + LastName + ", Address=" + Address + ", City="
				+ City + ", State=" + State + ", Pincode=" + Pincode + ", Phone=" + Phone + "]";
	}

	

}
