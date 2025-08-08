package training.iqgateway.staff.entity;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class DeleteNurseRequest {
	
	private String nurseId;
	private String from;
	private String to;
	private String hospitalId;
	public DeleteNurseRequest(String staffId, String from, String to, String hospitalId) {
		super();
		this.nurseId = staffId;
		this.from = from;
		this.to = to;
		this.hospitalId = hospitalId;
	}
	
	

}
