package training.iqgateway.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import training.iqgateway.entity.HospitalRegistrationEntity;
import training.iqgateway.repository.HospitalRegistrationRepository;

@Service
public class HospitalRegistrationServiceImpl implements HospitalRegistrationService {
	
	
	@Autowired
	HospitalRegistrationRepository hospitalRegistrationRepo;
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	
	
	public List<HospitalRegistrationEntity> findAllHospitals(){
		List<HospitalRegistrationEntity> listOfHospitals =   hospitalRegistrationRepo.findAll();
		return listOfHospitals;
	}


	@Override
	public HospitalRegistrationEntity registerHospital(HospitalRegistrationEntity hospitalEntity) throws DuplicateKeyException {
		// TODO Auto-generated method stub
		
		return mongoTemplate.insert(hospitalEntity);
	}
	
}
