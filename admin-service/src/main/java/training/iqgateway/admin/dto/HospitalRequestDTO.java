package training.iqgateway.admin.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;


@Data
public class HospitalRequestDTO {
	private String _id;
	private String userId; // Added userId field
	private String name;
	private String ceoName;
	private String certificate;
	private String kmcNumber;
	private String password;
	
	
	private ContactDetails contactDetails;
	private Address address;
	
	private List<String> staffDetails = new ArrayList<>(); // Initialize empty list
    private String registrationStatus;
    
    
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
