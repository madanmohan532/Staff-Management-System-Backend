package training.iqgateway.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "hospital_details")
public class HospitalRegistrationEntity {
	@Id
    private String _id;
    private String userId; 
    
    
    private String name;
    private String ceoName;
    private String certificate;
    private String kmcNumber;
    public String getKmcNumber() {
		return kmcNumber;
	}



	public void setKmcNumber(String kmcNumber) {
		this.kmcNumber = kmcNumber;
	}

	private String password; 
    
    private Address address;
    
   
    private ContactDetails contactDetails;
    
   @Field(name = "staff_details")
    private List<String> staffDetails = new ArrayList<>();
   @Field(name = "registration_status")
    private String registrationStatus; 
    
    
    public HospitalRegistrationEntity() {
		// TODO Auto-generated constructor stub
	}
    
    
    
    public HospitalRegistrationEntity(String _id, String userId, String name, String ceoName, String certificate, String kmcNumber,
			String password, Address address, ContactDetails contactDetails, List<String> staffDetails,
			String registrationStatus) {
		super();
		this._id = _id;
		this.userId = userId;
		this.name = name;
		this.ceoName = ceoName;
		this.certificate = certificate;
		this.kmcNumber = kmcNumber;
		this.password = password;
		this.address = address;
		this.contactDetails = contactDetails;
		this.staffDetails = staffDetails;
		this.registrationStatus = registrationStatus;
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
        
        
        
       
    }
    
    @Data
    public static class ContactDetails {
        private String phone;
        
        @Indexed(unique = true)
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
        
		
		
		
		
        
        
    }

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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



	@Override
	public String toString() {
		return "HospitalRegistrationEntity [_id=" + _id + ", userId=" + userId + ", name=" + name + ", ceoName="
				+ ceoName + ", certificate=" + certificate + ", kmcNumber=" + kmcNumber + ", password=" + password
				+ ", address=" + address + ", contactDetails=" + contactDetails + ", staffDetails=" + staffDetails
				+ ", registrationStatus=" + registrationStatus + "]";
	}
    
	
	
    
    
   
}
