package training.iqgateway.dto;

import java.util.List;

import training.iqgateway.entity.Address;
import training.iqgateway.entity.ContactDetails;

public class NurseRegistrationRequestDTO {
	

	
	private String _id;
	private String firstName;
	private String lastName;
	private String password;
	private ContactDetails contactDetails;
	private String certificate; // base64 encoded
	private String certificateNumber;
	private Integer yearOfExperience;
	public Integer getYearOfExperience() {
		return yearOfExperience;
	}


	public void setYearOfExperience(Integer yearOfExperience) {
		this.yearOfExperience = yearOfExperience;
	}

	private Address address;
	private List<String> skills;
	private String selfDescription;

	// Constructors
	public NurseRegistrationRequestDTO() {
	}
	
	
	public NurseRegistrationRequestDTO(String _id, String firstName, String lastName, String password,
			ContactDetails contactDetails, String certificate, String certificateNumber, Integer yearOfExperience,
			Address address, List<String> skills, String selfDescription) {
		super();
		this._id = _id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.contactDetails = contactDetails;
		this.certificate = certificate;
		this.certificateNumber = certificateNumber;
		this.yearOfExperience = yearOfExperience;
		this.address = address;
		this.skills = skills;
		this.selfDescription = selfDescription;
	}


	public NurseRegistrationRequestDTO(String _id, String firstName, String lastName, String password,
			ContactDetails contactDetails, String certificate, String certificateNumber, Address address,
			List<String> skills, String selfDescription) {
		super();
		this._id = _id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.contactDetails = contactDetails;
		this.certificate = certificate;
		this.certificateNumber = certificateNumber;
		this.address = address;
		this.skills = skills;
		this.selfDescription = selfDescription;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public NurseRegistrationRequestDTO(String firstName, String lastName, String password,
			ContactDetails contactDetails, String certificate, String certificateNumber, Address address,
			List<String> skills, String selfDescription) {
		super();

		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.contactDetails = contactDetails;
		this.certificate = certificate;
		this.certificateNumber = certificateNumber;
		this.address = address;
		this.skills = skills;
		this.selfDescription = selfDescription;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ContactDetails getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(ContactDetails contactDetails) {
		this.contactDetails = contactDetails;
	}

	public String getCertificate() {
		return certificate;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}

	public String getCertificateNumber() {
		return certificateNumber;
	}

	public void setCertificateNumber(String certificateNumber) {
		this.certificateNumber = certificateNumber;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	public String getSelfDescription() {
		return selfDescription;
	}

	public void setSelfDescription(String selfDescription) {
		this.selfDescription = selfDescription;
	}


	@Override
	public String toString() {
		return "NurseRegistrationRequestDTO [_id=" + _id + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", password=" + password + ", contactDetails=" + contactDetails + ", certificate=" + certificate
				+ ", certificateNumber=" + certificateNumber + ", yearOfExperience=" + yearOfExperience + ", address="
				+ address + ", skills=" + skills + ", selfDescription=" + selfDescription + "]";
	}

	

	// Getters and Setters for all fields...

}