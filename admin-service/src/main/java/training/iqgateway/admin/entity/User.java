package training.iqgateway.admin.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "users")
public class User {
	@Field("_id")
	private String _id;
	@Field("verificationStatus")
	private String verificationStatus; 
	@Field("email")// e.g., "PENDING", "VERIFIED", "REJECTED"
	private String email;
	@Field("password")
	private String password;
	@Field("role") // e.g., "ADMIN", "USER", etc.
	private String role; // e.g., "ADMIN", "USER", etc.
	

	// Constructors, Getters and Setters
	

}
