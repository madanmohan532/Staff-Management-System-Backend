package training.iqgateway.staff.service;

import java.util.List;

import training.iqgateway.staff.entity.Nurse;

public interface NurseService {
	
	
	Nurse getNurseById(String nurseId);

	Nurse updateNurse(Nurse nurse);

	Nurse setNurseAvailability(String nurseId, boolean availbality);

	List<Nurse.WorkingHour> getWorkingHours(String nurseId);
	
	List<Nurse.WorkSchedule> getWorkingSchedule(String nurseId);

}
