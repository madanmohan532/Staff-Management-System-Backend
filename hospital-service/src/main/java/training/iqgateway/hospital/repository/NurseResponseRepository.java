package training.iqgateway.hospital.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import training.iqgateway.hospital.dto.NurseResponseDTO;

@Repository
public interface NurseResponseRepository extends MongoRepository<NurseResponseDTO, String> {

	// This interface can be extended with custom query methods if needed
	// For example, to find nurses by specific criteria or request details

}
