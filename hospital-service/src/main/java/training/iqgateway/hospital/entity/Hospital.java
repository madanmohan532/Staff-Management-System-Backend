package training.iqgateway.hospital.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "hospital_details")
public class Hospital {
	@Id
	private String _id;
	private String userId;
	private String name;
	private String ceoName;
	private String certificate;
	private String kmcNumber;

	private String password;

	private Address address;

	private ContactDetails contactDetails;

	@Field(name = "staff_details")
	private List<String> staffDetails;
	@Field(name = "registration_status")
	private String registrationStatus;

	@Data
	public static class Address {
		private String street;
		private String city;
		private String state;
		private String pincode;

	}

	@Data
	public static class ContactDetails {
		
		
		private String phone;

		@Indexed(unique = true, sparse = true)
		private String email;

		public ContactDetails(String phone, String email) {
			super();
			this.phone = phone;
			this.email = email;
		}
		public ContactDetails() {
			// Default constructor
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
}
