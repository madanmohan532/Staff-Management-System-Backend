package training.iqgateway.staff.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import training.iqgateway.staff.entity.HospitalNurse;
import training.iqgateway.staff.entity.LeaveDetail;
import training.iqgateway.staff.entity.Nurse;
import training.iqgateway.staff.entity.Patient;
import training.iqgateway.staff.service.NurseService;
import training.iqgateway.staff.service.PatientService;

@RestController
@RequestMapping("/api/nurse")
@CrossOrigin(origins = "*")
public class NurseController {

	@Autowired
	NurseService nurseService;
	
	@Autowired
	RestTemplate restTemplate;

	@Autowired
	private PatientService patientService;

	@GetMapping("/{nurseId}")
	public ResponseEntity<?> getNurseDetails(@PathVariable String nurseId) {
		// Logic to fetch nurse details by ID

		// Placeholder for actual nurse retrieval logic

		Nurse nurse = null;

		try {
			nurse = nurseService.getNurseById(nurseId);
		} catch (Exception e) {
			return new ResponseEntity<>("Nurse not found with id: " + nurseId, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(nurse, HttpStatus.OK);
	}
	
	@GetMapping("/getNurse/{email}")
	public ResponseEntity<?> getNurseDetailsByEmail(@PathVariable String email) {
		// Logic to fetch nurse details by ID

		// Placeholder for actual nurse retrieval logic

		Nurse nurse = null;

		try {
			nurse = nurseService.getNurseByEmail(email);
		} catch (Exception e) {
			return new ResponseEntity<>("Nurse not found with email: " + email, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(nurse, HttpStatus.OK);
	}

	@PutMapping("updateNurse/")
	public ResponseEntity<?> updateNurseDetails(Nurse nurse) {
		// Logic to update nurse details

		// Placeholder for actual nurse update logic
		Nurse updatedNurse = null;
		try {
			updatedNurse = nurseService.updateNurse(nurse);
		} catch (Exception e) {
			return new ResponseEntity<>("Error updating nurse details: " + e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<>(updatedNurse, HttpStatus.OK);
	}
	
	
	@PutMapping("/setAvailability/{nurseId}/{availbality}")
	public ResponseEntity<?> setNurseAvailability(@PathVariable String nurseId,@PathVariable boolean availbality) {
		// Logic to set nurse availability

		// Placeholder for actual availability setting logic
		
		Nurse nurse = null;
		
		try {
			nurse = nurseService.setNurseAvailability(nurseId,availbality);
		} catch (Exception e) {
			return new ResponseEntity<>("Error setting nurse availability: " + e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<>(nurse, HttpStatus.OK);
	}
	
	
	@GetMapping("/getPatientDetails/{nurseId}")
	public ResponseEntity<?> getPatientDetails(@PathVariable String nurseId) {
		// Logic to fetch patient details assigned to the nurse

		// Placeholder for actual patient retrieval logic
		// This would typically involve fetching patients from a service or repository
		
		String validateWorkingStatusURI = "http://localhost:9193/api/hospital/nurse/validateWorkingStatus/" + nurseId;
		
		Map<Boolean,String> validationObject = restTemplate.getForObject(validateWorkingStatusURI, Map.class);
		
		
		
		if(validationObject.containsKey(false)) {
			return new ResponseEntity<>(validationObject, HttpStatus.NOT_FOUND);
		}
		
		ArrayList<Patient> patients = new ArrayList<>();
		
		HospitalNurse hospitalNurse = restTemplate.getForObject("http://localhost:9193/api/hospital/nurse/getHospitalNurseByStaffId/" + nurseId, HospitalNurse.class);
		
		hospitalNurse.getPatientsAllocatedTo().forEach(patient -> {
			patients.add(patientService.getPatientById(patient));
		});
		
		

		return new ResponseEntity<>(patients , HttpStatus.OK);
	}
	
	
	@GetMapping("/getPatientDetailsById/{patientId}")
	public ResponseEntity<?> getPatientDetailsById(@PathVariable String patientId) {
		// Logic to fetch patient details by ID

		// Placeholder for actual patient retrieval logic
		// This would typically involve fetching patients from a service or repository
		
		Patient patient = patientService.getPatientById(patientId);	
		
		
		
		
		return new ResponseEntity<>("Patient details for patient with ID: " + patientId, HttpStatus.OK);
	}
	
	@PutMapping("/applyLeave")
	public ResponseEntity<?> applyLeaveForNurse(@RequestBody LeaveDetail leaveDetail){
		
		nurseService.applyLeave(leaveDetail);
		
		return new ResponseEntity<>("Leave Applied Successfully",HttpStatus.OK);
		
	}
	
	
	@PutMapping("/updatePatientDetails")
	public ResponseEntity<?> updatePatientDetails(Patient patient) {
		// Logic to update patient details

		// Placeholder for actual patient update logic
		// This would typically involve updating the patient in a service or repository
		
		Patient updatedPatient = null;
		
		try {
			updatedPatient = patientService.updatePatient(patient);
		} catch (Exception e) {
			return new ResponseEntity<>("Error updating patient details: " + e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<>(updatedPatient, HttpStatus.OK);
	}
	
	@GetMapping("/getWorkingHours/{nurseId}")
	public ResponseEntity<?> getWorkingHoursOfNurse(@PathVariable String nurseId) {
		// Logic to fetch working hours of the nurse

		// Placeholder for actual working hours retrieval logic
		// This would typically involve fetching working hours from a service or repository
		
		List<Nurse.WorkingHour> workingHours = null;
		
		workingHours = nurseService.getWorkingHours(nurseId);
		
		
		return new ResponseEntity<>(workingHours, HttpStatus.OK);
	}
	
	
	@GetMapping("/getWorkSchedule/{nurseId}")
	public ResponseEntity<?> getWorkSchedule(@PathVariable String nurseId) {
		// Logic to fetch work schedule of the nurse

		// Placeholder for actual work schedule retrieval logic
		// This would typically involve fetching work schedule from a service or repository
		
		List<Nurse.WorkSchedule> workingSchedule = null;
		
			workingSchedule = nurseService.getWorkingSchedule(nurseId);


		return new ResponseEntity<>(workingSchedule, HttpStatus.OK);
	}
	
	
}
