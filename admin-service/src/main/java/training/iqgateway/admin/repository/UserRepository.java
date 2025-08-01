package training.iqgateway.admin.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import training.iqgateway.admin.entity.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
	
	
	// This interface will automatically provide methods for CRUD operations
	// on the User entity, such as save, findById, findAll, deleteById, etc.
	// Additional custom query methods can be defined here if needed.
	
	// Example of a custom query method:
	// List<User> findByEmail(String email);
	
	User findByEmail(String email);

}
