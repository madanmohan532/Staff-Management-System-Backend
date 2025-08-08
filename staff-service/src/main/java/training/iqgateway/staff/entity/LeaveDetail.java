package training.iqgateway.staff.entity;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class LeaveDetail {
	
	private String from;
	private String to;
	private String nurseId;

}
