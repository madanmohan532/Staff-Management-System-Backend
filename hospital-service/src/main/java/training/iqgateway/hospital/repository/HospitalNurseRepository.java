package training.iqgateway.hospital.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import training.iqgateway.hospital.entity.HospitalNurse;

@Repository
public interface HospitalNurseRepository extends MongoRepository<HospitalNurse, String> {

	// This interface can be extended with custom query methods if needed
	// For example, to find nurses by specific criteria or request details

	HospitalNurse deleteByStaffId(String staffId);
	
	HospitalNurse findByStaffId(String staffId);
	
	List<HospitalNurse> findByHospitalId(String hospitalId);
	
	HospitalNurse findByHospitalStaffId(String hospitalStaffId);
	
}
