package training.iqgateway.hospital.entity;

import lombok.Data;

@Data
public class RemoveHospitalNurse {
	
	private String nurseId;
	private String from;
	private String to;
	private String hospitalStaffId;

	private String hospitalId;
	private String curTime;
	
	

}
