package training.iqgateway.hospital.entity;

import lombok.Data;

@Data
public class DeleteNurseRequest {
	
	private String nurseId;
	private String from;
	private String to;
	private String hospitalId;
	

}
