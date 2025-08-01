package training.iqgateway.dto;

import java.util.List;

import lombok.Data;

@Data
public class HospitalRegistrationResponseDTO {
	private String _id;
    private String name;
    private String ceoName;
    private Address address;
    private String certificate;
    private String kmcNumber;
   
	public String getKmcNumber() {
		return kmcNumber;
	}

	public void setKmcNumber(String kmcNumber) {
		this.kmcNumber = kmcNumber;
	}

	private ContactDetails contactDetails;
    private List<String> staffDetails;
    private String registrationStatus;
    
    
    public HospitalRegistrationResponseDTO() {
		// TODO Auto-generated constructor stub
	}
    
    public HospitalRegistrationResponseDTO(String _id, String name, String ceoName,String certificate,String kmcNumber, Address address,
			ContactDetails contactDetails, List<String> staffDetails, String registrationStatus) {
		super();
		this._id = _id;
		this.name = name;
		this.ceoName = ceoName;
		this.certificate = certificate;
		this.kmcNumber = kmcNumber;
		this.address = address;
		this.contactDetails = contactDetails;
		this.staffDetails = staffDetails;
		this.registrationStatus = registrationStatus;
	}

	@Data
	public static class ContactDetails {
        private String phone;
        private String email;
        
        public ContactDetails() {
			// TODO Auto-generated constructor stub
		} 
        
        
		public ContactDetails(String phone, String email) {
			super();
			this.phone = phone;
			this.email = email;
		}


		public String getPhone() {
			return phone;
		}


		public void setPhone(String phone) {
			this.phone = phone;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}
        
		
		
        // Constructors, getters, and setters
    }
	
	@Data
	public static class Address {
        private String street;
        private String city;
        private String state;
        private String pincode;
        
        
        public Address() {
			// TODO Auto-generated constructor stub
		}


		public Address(String street, String city, String state, String pincode) {
			super();
			this.street = street;
			this.city = city;
			this.state = state;
			this.pincode = pincode;
		}


		public String getStreet() {
			return street;
		}


		public void setStreet(String street) {
			this.street = street;
		}


		public String getCity() {
			return city;
		}


		public void setCity(String city) {
			this.city = city;
		}


		public String getState() {
			return state;
		}


		public void setState(String state) {
			this.state = state;
		}


		public String getPincode() {
			return pincode;
		}


		public void setPincode(String pincode) {
			this.pincode = pincode;
		}
        
        
        // Constructors, getters, and setters
    }

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCeoName() {
		return ceoName;
	}

	public void setCeoName(String ceoName) {
		this.ceoName = ceoName;
	}
	
	 
    public String getCertificate() {
		return certificate;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}


	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public ContactDetails getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(ContactDetails contactDetails) {
		this.contactDetails = contactDetails;
	}

	public List<String> getStaffDetails() {
		return staffDetails;
	}

	public void setStaffDetails(List<String> staffDetails) {
		this.staffDetails = staffDetails;
	}

	public String getRegistrationStatus() {
		return registrationStatus;
	}

	public void setRegistrationStatus(String registrationStatus) {
		this.registrationStatus = registrationStatus;
	}
	
	
}
