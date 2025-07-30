package training.iqgateway.hospital.entity;

import lombok.Data;

@Data
public class NurseRequest {
	
	private String staffId;
	private String date;
	private String from;
	private String to;
	private String hospitalId;

}
