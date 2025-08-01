package training.iqgateway.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import training.iqgateway.entity.NurseRegistrationEntity;
import training.iqgateway.repository.NurseRegistrationRepository;

@Service
public class NurseRegistrationServiceImpl implements NurseRegistrationService {
	
	@Autowired
	NurseRegistrationRepository nurseRegistrationRepo;
	
	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public NurseRegistrationEntity registerNurse(NurseRegistrationEntity nurse) throws DuplicateKeyException
			 {
		// TODO Auto-generated method stub
		
		
		return mongoTemplate.insert(nurse);
	}

	@Override
	public List<NurseRegistrationEntity> findAllNurses() {
		// TODO Auto-generated method stub
		return nurseRegistrationRepo.findAll();
	}

}
