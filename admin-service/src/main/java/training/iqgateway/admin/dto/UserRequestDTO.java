package training.iqgateway.admin.dto;

import lombok.Data;

@Data
public class UserRequestDTO {
	
	private String email;
	private String password;
	private String role;
	private String verificationStatus;
	

}
