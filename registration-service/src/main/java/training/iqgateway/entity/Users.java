package training.iqgateway.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class Users {
	
	@Id
	private String _id;
	private String email;
	private String password;
	private String role;
	private String verificationStatus;

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getVerificationStatus() {
		return verificationStatus;
	}

	public void setVerificationStatus(String verificationStatus) {
		this.verificationStatus = verificationStatus;
	}

	public Users(String _id, String email, String password, String role, String verificationStatus) {
		super();
		this._id = _id;
		this.email = email;
		this.password = password;
		this.role = role;
		this.verificationStatus = verificationStatus;
	}

	@Override
	public String toString() {
		return "Users [_id=" + _id + ", email=" + email + ", password=" + password + ", role=" + role
				+ ", verificationStatus=" + verificationStatus + "]";
	}

}
