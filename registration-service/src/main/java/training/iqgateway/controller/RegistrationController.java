package training.iqgateway.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import training.iqgateway.dto.HospitalRegistrationRequestDTO;
import training.iqgateway.dto.HospitalRegistrationResponseDTO;
import training.iqgateway.dto.NurseRegistrationRequestDTO;
import training.iqgateway.dto.NurseResponseDTO;
import training.iqgateway.entity.HospitalRegistrationEntity;
import training.iqgateway.entity.NurseRegistrationEntity;
import training.iqgateway.service.HospitalRegistrationService;
import training.iqgateway.service.NurseRegistrationService;
import training.iqgateway.util.HospitalUtils;
import training.iqgateway.util.NurseUtils;

@RestController
@CrossOrigin
@RequestMapping("api/registration")
public class RegistrationController {



	@Autowired
	HospitalRegistrationService hospitalRegistrationService;
	
	@Autowired
	NurseRegistrationService nurseRegistrationService;


	@GetMapping("/hospitals")
	public List<HospitalRegistrationResponseDTO> getAllHospitals() {
	    List<HospitalRegistrationResponseDTO> allHospitalResponseDTO = new ArrayList<>();

	    List<HospitalRegistrationEntity> listOfHospitalEntity = hospitalRegistrationService.findAllHospitals();

	    for (HospitalRegistrationEntity hospital : listOfHospitalEntity) {
	        

	        allHospitalResponseDTO.add(HospitalUtils.convertToResponseDTO(hospital));
	    }

	    return allHospitalResponseDTO;
	}
	

	@PostMapping("/hospital")
	public ResponseEntity<?> registerHospital(@RequestBody HospitalRegistrationRequestDTO hospitalRequestDTO) {
		
		
	 HospitalRegistrationEntity registeredHospitalEntity =	null;
	 try {
		 HospitalRegistrationEntity convertToRegistrationEntity = HospitalUtils.convertToRegistrationEntity(hospitalRequestDTO);
		 System.out.println(convertToRegistrationEntity);
		 registeredHospitalEntity = hospitalRegistrationService.registerHospital(convertToRegistrationEntity);
	 }catch (DuplicateKeyException mwe) {
		// TODO: handle exception
		 mwe.printStackTrace();
		 System.out.println("inside catch block gsgsgs");
		 return new ResponseEntity<>("Email already exists, want to login ?",HttpStatus.CONFLICT);
	}
		
		return new ResponseEntity<>(HospitalUtils.convertToResponseDTO(registeredHospitalEntity),HttpStatus.CREATED);
	}
	
	
	@PostMapping("/nurse")
	public ResponseEntity<?> registerNurse(@RequestBody NurseRegistrationRequestDTO nurseRequestDTO) {
	 NurseRegistrationEntity nurse = null;
	 
			try {
				nurse =  nurseRegistrationService.registerNurse(NurseUtils.convertToNurseRegistrationEntity(nurseRequestDTO));
			} catch (DuplicateKeyException e) {
				// TODO: handle exception
				System.out.println("inside catch block of nurse");
				 return new ResponseEntity<>("Email already exists, want to login ?",HttpStatus.CONFLICT);
			}
		return new ResponseEntity<>(NurseUtils.convertToNurseRegistrationResponseDTO(nurse),HttpStatus.CREATED);
	}
	
	
	@GetMapping("/nurses")
	public List<NurseResponseDTO> getAllNurses() {
	    List<NurseResponseDTO> allNurseResponseDTO = new ArrayList<>();

	    List<NurseRegistrationEntity> listOfNurseEntity = nurseRegistrationService.findAllNurses();

	    for (NurseRegistrationEntity nurse : listOfNurseEntity) {
	        

	    	allNurseResponseDTO.add(NurseUtils.convertToNurseRegistrationResponseDTO(nurse));
	    }

	    return allNurseResponseDTO;
	}

}
