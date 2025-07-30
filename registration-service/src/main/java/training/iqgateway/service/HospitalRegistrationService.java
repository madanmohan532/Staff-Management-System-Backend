package training.iqgateway.service;

import java.util.List;

import org.springframework.dao.DuplicateKeyException;

import training.iqgateway.entity.HospitalRegistrationEntity;

public interface HospitalRegistrationService {
	List<HospitalRegistrationEntity> findAllHospitals();
	
	

	HospitalRegistrationEntity registerHospital(HospitalRegistrationEntity hospitalEntity) throws DuplicateKeyException ;
}
