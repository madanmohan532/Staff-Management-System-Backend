package training.iqgateway.admin.service;

import java.util.List;

import training.iqgateway.admin.entity.Hospital;

public interface HospitalService {
	
	public List<Hospital> getAllHospitals();

	public Hospital updateHospitalRegistrationStatus(String registrationStatus, String hospitalId,String userId);

	public boolean deleteHospital(String hospitalId);

	public Hospital updateHospital(Hospital hospital);
	

}
