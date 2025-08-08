package training.iqgateway.hospital.entity;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;

@Data
public class RequestResponse {
	
	private String nurseId;
	private String status;
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private String from;
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private String to;
	private String date;
	private String hospitalId;


}