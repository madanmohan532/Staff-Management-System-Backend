package training.iqgateway.hospital.dto;

import java.time.Instant;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
public class WorkScheduleDTO {
	@Field(name = "date")
	private String date;
	@Field(name = "from")
	private String from;
	@Field(name = "to")
	private String to;
	@Field(name = "hospital_id")
	private String hospitalId;
	@Field(name = "status")
	private String status;
	public WorkScheduleDTO(String date, String from, String to, String hospitalId, String status) {
		super();
		this.date = date;
		this.from = from;
		this.to = to;
		this.hospitalId = hospitalId;
		this.status = status;
	}
	
	
}