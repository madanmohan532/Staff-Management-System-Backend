package training.iqgateway.util;

import java.util.List;
import java.util.stream.Collectors;

import training.iqgateway.dto.NurseRegistrationRequestDTO;
import training.iqgateway.dto.NurseResponseDTO;
import training.iqgateway.entity.Address;
import training.iqgateway.entity.ContactDetails;
import training.iqgateway.entity.NurseRegistrationEntity;


public class NurseUtils {
	
	public static NurseResponseDTO convertToNurseRegistrationResponseDTO(NurseRegistrationEntity nurse) {
		
		NurseResponseDTO nurseResponseDTO = new NurseResponseDTO();
		
		nurseResponseDTO.set_id(nurse.get_id());
		
		
NurseRegistrationEntity.Address address = nurse.getAddress();
		
		String state = address.getState();
		String city = address.getCity();
		String pincode = address.getPincode();
		String street = address.getStreet();
		
		
		NurseRegistrationEntity.ContactDetails contact = nurse.getContactDetails();

		String email = contact.getEmail();
		String phone = contact.getPhone();
		
		
		
		nurseResponseDTO.setAddress(new Address(street,state,city,pincode));
		nurseResponseDTO.setAvailableStatus(nurse.isAvailableStatus());
		nurseResponseDTO.setCertificate(nurse.getCertificate());
		nurseResponseDTO.setCertificateNumber(nurse.getCertificateNumber());
		nurseResponseDTO.setContactDetails(new ContactDetails(phone,email));
		nurseResponseDTO.setCurrentWorkingStatus(nurse.isCurrentWorkingStatus());
		nurseResponseDTO.setFirstName(nurse.getFirstName());
		nurseResponseDTO.setLastName(nurse.getLastName());
		
		
		List<NurseRegistrationEntity.LeaveDetail> nurseEntityLeaveDetails = nurse.getLeaveDetails();
		
//		List<training.iqgateway.entity.LeaveDetail> nurseResponseLeaveDetails = new ArrayList<>();
//		String fromDate = null;
//		String toDate = null;
		
		
//		for(NurseRegistrationEntity.LeaveDetail nurseEntityLeveDetail : nurseEntityLeaveDetails) {
//			System.out.println(nurseEntityLeveDetail);
//			nurseResponseLeaveDetails.add(
//					new training.iqgateway.entity.LeaveDetail(nurseEntityLeveDetail.getFromDate(),
//							nurseEntityLeveDetail.getToDate()));
//			
//		}
//		
		
		List<training.iqgateway.entity.LeaveDetail> nurseResponseLeaveDetails = nurseEntityLeaveDetails.stream()
			    .filter(ld -> ld.getFromDate() != null && ld.getToDate() != null)
			    .map(leaveDetail -> new training.iqgateway.entity.LeaveDetail(
			        leaveDetail.getFromDate().toString(),
			        leaveDetail.getToDate().toString()))
			    .collect(Collectors.toList());
		
		nurseResponseDTO.setLeaveDetails(nurseResponseLeaveDetails);
		nurseResponseDTO.setRegistrationStatus(nurse.getRegistrationStatus());
		nurseResponseDTO.setSelfDescription(nurse.getSelfDescription());
		nurseResponseDTO.setSkills(nurse.getSkills());
		nurseResponseDTO.setUserId(nurse.getUserId());
		
		
		
		List<NurseRegistrationEntity.WorkingHour> nurseEntityWorkingHours = nurse.getWorkingHours();
		
		List<training.iqgateway.entity.WorkingHour> nurseResponseWorkingHours = nurseEntityWorkingHours.stream()
				.filter(wh -> wh.getDate() != null && wh.getFrom() !=null && 
				wh.getTo() !=null && wh.getHospitalId() !=null)
				.map(workingHour -> new training.iqgateway.entity.WorkingHour(workingHour.getDate(), workingHour.getFrom().toString(), 
						workingHour.getTo().toString()	,workingHour.getHospitalId()))
				.collect(Collectors.toList());
		
		
		
		nurseResponseDTO.setWorkingHours(nurseResponseWorkingHours);
		
		
		List<NurseRegistrationEntity.WorkSchedule> nurseEntityWorkSchedules = nurse.getWorkSchedule();
		
		List<training.iqgateway.entity.WorkSchedule> nurseResponseWorkingSchedules = nurseEntityWorkSchedules.stream()
				.filter(ws -> ws.getDate() !=null && ws.getFrom() !=null && 
				ws.getTo() !=null && ws.getHospitalId() !=null && ws.getStatus() !=null)
				.map(workingSchedule -> new training.iqgateway.entity.WorkSchedule(workingSchedule.getDate(), workingSchedule.getFrom().toString(), 
						workingSchedule.getTo().toString(), workingSchedule.getHospitalId(), workingSchedule.getStatus()))
				.collect(Collectors.toList());
		
		nurseResponseDTO.setWorkSchedule(nurseResponseWorkingSchedules);
		
		return nurseResponseDTO;
		
	}
	
	public static NurseRegistrationEntity convertToNurseRegistrationEntity(NurseRegistrationRequestDTO nurseRequestDTO) {
		NurseRegistrationEntity nurse = new NurseRegistrationEntity();
		System.out.println(nurseRequestDTO.get_id());
		nurse.set_id(nurseRequestDTO.get_id());
		
		Address address = nurseRequestDTO.getAddress();
		
		String state = address.getState();
		String city = address.getCity();
		String pincode = address.getPincode();
		String street = address.getStreet();
		
		
		ContactDetails contact = nurseRequestDTO.getContactDetails();
		
		

		String email = contact.getEmail();
		String phone = contact.getPhone();
		
		
		System.out.println(phone+" "+email);
		
		
		
		
		nurse.setAddress(new NurseRegistrationEntity.Address(street,city,state,pincode));
		nurse.setCertificate(nurseRequestDTO.getCertificate());
		nurse.setCertificateNumber(nurseRequestDTO.getCertificateNumber());
		nurse.setContactDetails(new NurseRegistrationEntity.ContactDetails(phone,email));
		nurse.setFirstName(nurseRequestDTO.getFirstName());
		nurse.setLastName(nurseRequestDTO.getLastName());
		nurse.setPassword(nurseRequestDTO.getPassword());
		nurse.setSkills(nurseRequestDTO.getSkills());
		nurse.setSelfDescription(nurseRequestDTO.getSelfDescription());
		
		return nurse;
		
	}

}
