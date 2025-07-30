package training.iqgateway.service;

import java.util.List;

import org.springframework.dao.DuplicateKeyException;

import training.iqgateway.entity.NurseRegistrationEntity;

public interface NurseRegistrationService {
	
	
	NurseRegistrationEntity registerNurse(NurseRegistrationEntity nurse) throws DuplicateKeyException;

	List<NurseRegistrationEntity> findAllNurses();

}
