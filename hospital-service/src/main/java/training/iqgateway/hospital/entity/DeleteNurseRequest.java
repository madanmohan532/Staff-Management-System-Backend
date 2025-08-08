package training.iqgateway.hospital.entity;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class DeleteNurseRequest {
	
	private String nurseId;
	private String from;
	private String to;
	private String hospitalId;
	

}