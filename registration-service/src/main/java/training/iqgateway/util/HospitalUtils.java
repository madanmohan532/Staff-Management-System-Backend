package training.iqgateway.util;

import java.security.SecureRandom;

import training.iqgateway.dto.HospitalRegistrationRequestDTO;
import training.iqgateway.dto.HospitalRegistrationResponseDTO;
import training.iqgateway.entity.HospitalRegistrationEntity;

public class HospitalUtils {

	public static HospitalRegistrationResponseDTO convertToResponseDTO(HospitalRegistrationEntity hospital) {

		HospitalRegistrationResponseDTO hospitalResponseDTO = new HospitalRegistrationResponseDTO();

		HospitalRegistrationResponseDTO.Address address = new HospitalRegistrationResponseDTO.Address();
		HospitalRegistrationResponseDTO.ContactDetails contactDetails = new HospitalRegistrationResponseDTO.ContactDetails();

		hospitalResponseDTO.set_id(hospital.get_id());
		hospitalResponseDTO.setName(hospital.getName());
		hospitalResponseDTO.setCeoName(hospital.getCeoName());
		hospitalResponseDTO.setCertificate(hospital.getCertificate());
		hospitalResponseDTO.setKmcNumber(hospital.getKmcNumber());
		address.setCity(hospital.getAddress().getCity());
		address.setPincode(hospital.getAddress().getPincode());
		address.setState(hospital.getAddress().getState());
		address.setStreet(hospital.getAddress().getStreet());

		hospitalResponseDTO.setAddress(address);

		contactDetails.setEmail(hospital.getContactDetails().getEmail());
		contactDetails.setPhone(hospital.getContactDetails().getPhone());

		hospitalResponseDTO.setContactDetails(contactDetails);
		hospitalResponseDTO.setStaffDetails(hospital.getStaffDetails());
		hospitalResponseDTO.setRegistrationStatus(hospital.getRegistrationStatus());
		return hospitalResponseDTO;
	}

	public static HospitalRegistrationEntity convertToRegistrationEntity(
			HospitalRegistrationRequestDTO hospitalRequestDTO) {
		HospitalRegistrationEntity hospitalEntity = new HospitalRegistrationEntity();

		hospitalEntity.setName(hospitalRequestDTO.getName());
		hospitalEntity.setCeoName(hospitalRequestDTO.getCeoName());
		hospitalEntity.setCertificate(hospitalRequestDTO.getCertificate());
		hospitalEntity.setKmcNumber(hospitalRequestDTO.getKmcNumber());

		String city = hospitalRequestDTO.getAddress().getCity();
		String street = hospitalRequestDTO.getAddress().getStreet();
		String state = hospitalRequestDTO.getAddress().getState();
		String pincode = hospitalRequestDTO.getAddress().getPincode();

		hospitalEntity.setAddress(new HospitalRegistrationEntity.Address(street, city, state, pincode));

		hospitalEntity.setContactDetails(new HospitalRegistrationEntity.ContactDetails(
				hospitalRequestDTO.getContactDetails().getPhone(), hospitalRequestDTO.getContactDetails().getEmail()));
		hospitalEntity
				.set_id(HospitalUtils.HospitalIdGenerator());
		hospitalEntity.setStaffDetails(hospitalRequestDTO.getStaffDetails());
		hospitalEntity.setRegistrationStatus(hospitalRequestDTO.getRegistrationStatus());
		hospitalEntity.setPassword(hospitalRequestDTO.getPassword());
		return hospitalEntity;
	}

	public static String HospitalIdGenerator() {
		long timestamp = System.currentTimeMillis();
	    int random = new SecureRandom().nextInt(900); // 0-899
	    return "HOS"+String.format("%07d", (timestamp % 9_000_000) + random);
	}

}
