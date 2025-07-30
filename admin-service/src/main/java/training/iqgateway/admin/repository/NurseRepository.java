package training.iqgateway.admin.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import training.iqgateway.admin.entity.Nurse;

@Repository
public interface NurseRepository extends MongoRepository<Nurse, String> {
	// This interface will automatically inherit methods for CRUD operations
	// and can be extended with custom query methods if needed.
	
	

}
