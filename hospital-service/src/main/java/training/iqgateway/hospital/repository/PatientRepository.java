package training.iqgateway.hospital.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import training.iqgateway.hospital.entity.Patient;

@Repository
public interface PatientRepository extends MongoRepository<Patient, String> {

	List<Patient> findByHospitalId(String hospitalId);
	
	Patient findByPatientId(String patientId);

}
