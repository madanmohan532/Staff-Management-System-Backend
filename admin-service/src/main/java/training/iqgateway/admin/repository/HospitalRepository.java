package training.iqgateway.admin.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import training.iqgateway.admin.entity.Hospital;

@Repository
public interface HospitalRepository extends MongoRepository<Hospital, String> {
	// This interface will automatically provide methods for CRUD operations
	// on the Hospital entity, such as save, findById, findAll, deleteById, etc.
	// Additional custom query methods can be defined here if needed.
	
	

}
