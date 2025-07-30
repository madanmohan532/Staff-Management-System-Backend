package training.iqgateway.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import java.util.List;

@Document(collection = "admin_details") // replace with your actual collection name
public class Admin {

    @Id
    @Field("_id")
    private String id;

    @Field("first_name")
    private String firstName;

    @Field("last_name")
    private String lastName;

    @Field("contactDetails")
    private ContactDetails contactDetails;

    @Field("address")
    private Address address;

    @Field("unique_verification_id")
    private String uniqueVerificationId;

    @Field("password")
    private String password;

    @Field("approved_registration_ids")
    private List<String> approvedRegistrationIds;

    // Getters and Setters
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
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
    public ContactDetails getContactDetails() {
        return contactDetails;
    }
    public void setContactDetails(ContactDetails contactDetails) {
        this.contactDetails = contactDetails;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    public String getUniqueVerificationId() {
        return uniqueVerificationId;
    }
    public void setUniqueVerificationId(String uniqueVerificationId) {
        this.uniqueVerificationId = uniqueVerificationId;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public List<String> getApprovedRegistrationIds() {
        return approvedRegistrationIds;
    }
    public void setApprovedRegistrationIds(List<String> approvedRegistrationIds) {
        this.approvedRegistrationIds = approvedRegistrationIds;
    }

    // Nested static class for contactDetails
    public static class ContactDetails {

        @Field("phone")
        private String phone;

        @Field("email")
        private String email;

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

    // Nested static class for address
    public static class Address {

        @Field("street")
        private String street;

        @Field("city")
        private String city;

        @Field("state")
        private String state;

        @Field("pincode")
        private String pincode;

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
}
