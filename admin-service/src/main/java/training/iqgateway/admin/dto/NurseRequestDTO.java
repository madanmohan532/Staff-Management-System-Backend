package training.iqgateway.admin.dto;

import java.util.List;

import lombok.Data;

@Data
public class NurseRequestDTO {

	
	private String _id;
	private String userId; // Added userId field
	private String firstName;
	private String lastName;
	private String password;
	private ContactDetails contactDetails;
	private String certificate; // base64 encoded
	private String certificateNumber;
	private Integer yearOfExperience;
	private Address address;
	private List<String> skills;
	private String selfDescription;
	private String registrationStatus;
	// "approved", "rejected", "pending"
	
	
	@Data
	public static class ContactDetails {
        private String phone;
        private String email;
    }
    
    @Data
	public static class Address {
        private String street;
        private String city;
        private String state;
        private String pincode;
    }
	
}
