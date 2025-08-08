package training.iqgateway.staff.entity;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class RequestResponse {
	
	private String nurseId;
	private String status;
	private String from;
	private String to;
	private String date;
	private String hospitalId;


}
