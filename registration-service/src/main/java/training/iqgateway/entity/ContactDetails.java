package training.iqgateway.entity;

public class ContactDetails {
    private String phone;
    private String email;

    // Constructors
    public ContactDetails() {}

    public ContactDetails(String phone, String email) {
        this.phone = phone;
        this.email = email;
    }

    // Getters and Setters
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

	@Override
	public String toString() {
		return "ContactDetails [phone=" + phone + ", email=" + email + "]";
	}
    
    
}
