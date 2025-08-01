package training.iqgateway.admin.dto;

import java.util.List;

import lombok.Data;


@Data
public class HospitalResponseDTO {
	private String _id;
    private String name;
    private String ceoName;
    private Address address;
    private String certificate;
    private String password;
    private String kmcNumber;
    private ContactDetails contactDetails;
    private List<String> staffDetails;
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
