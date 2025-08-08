package training.iqgateway.staff.entity;

import lombok.Data;

@Data
public class ClockInRequest {
	
	
	private String clockInTime;
	private String date;
	private String to;
	private String nurseId;
	private String hospitalId;
	

}
