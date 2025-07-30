package training.iqgateway.staff.service;

import training.iqgateway.staff.entity.Patient;

public interface PatientService {
	
	Patient getPatientById(String patientId);

	Patient updatePatient(Patient patient);

}
