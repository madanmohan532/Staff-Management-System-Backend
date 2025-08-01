package training.iqgateway.admin.utils;

import training.iqgateway.admin.dto.HospitalRequestDTO;
import training.iqgateway.admin.dto.HospitalResponseDTO;
import training.iqgateway.admin.entity.Hospital;



public class HospitalUtils {
	
	public static HospitalResponseDTO convertToHospitalResponseDTO(Hospital hospital) {

		HospitalResponseDTO hospitalResponseDTO = new HospitalResponseDTO();

		HospitalResponseDTO.Address address = new HospitalResponseDTO.Address();
		HospitalResponseDTO.ContactDetails contactDetails = new HospitalResponseDTO.ContactDetails();

		hospitalResponseDTO.set_id(hospital.get_id());
		hospitalResponseDTO.setName(hospital.getName());
		hospitalResponseDTO.setCeoName(hospital.getCeoName());
		hospitalResponseDTO.setCertificate(hospital.getCertificate());
		hospitalResponseDTO.setKmcNumber(hospital.getKmcNumber());
		hospitalResponseDTO.setPassword(hospital.getPassword());
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

//	public static Hospital convertToHospitalEntity(HospitalRequestDTO hospitalRequestDTO) {
//		// TODO Auto-generated method stub
//		Hospital hospitalEntity = new Hospital();
//
//		hospitalEntity.setName(hospitalRequestDTO.getName());
//		hospitalEntity.setCeoName(hospitalRequestDTO.getCeoName());
//		hospitalEntity.setCertificate(hospitalRequestDTO.getCertificate());
//
//		String city = hospitalRequestDTO.getAddress().getCity();
//		String street = hospitalRequestDTO.getAddress().getPincode();
//		String state = hospitalRequestDTO.getAddress().getState();
//		String pincode = hospitalRequestDTO.getAddress().getPincode();
//
//		hospitalEntity.setAddress(new Hospital.Address(street, city, state, pincode));
//
//		hospitalEntity.setContactDetails(new Hospital.ContactDetails(
//				hospitalRequestDTO.getContactDetails().getPhone(), hospitalRequestDTO.getContactDetails().getEmail()));
//		hospitalEntity
//				.set_id(HospitalUtils.HospitalIdGenerator(hospitalRequestDTO.getContactDetails().getPhone(), pincode));
//		hospitalEntity.setStaffDetails(hospitalRequestDTO.getStaffDetails());
//		hospitalEntity.setRegistrationStatus(hospitalRequestDTO.getRegistrationStatus());
//		return hospitalEntity;
//	}

}
