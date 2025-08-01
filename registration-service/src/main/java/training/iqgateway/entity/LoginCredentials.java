package training.iqgateway.entity;

public class LoginCredentials {

	private String userId;
	private String password;
	private String role;
	private String jwtToken;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public String getJwtToken() {
		return jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}

	public LoginCredentials(String userId, String password, String role, String jwtToken) {
		super();
		this.userId = userId;
		this.password = password;
		this.role = role;
		this.jwtToken = jwtToken;
	}

	@Override
	public String toString() {
		return "LoginCredentials [userId=" + userId + ", password=" + password + ", role=" + role + ", jwtToken="
				+ jwtToken + "]";
	}

}
