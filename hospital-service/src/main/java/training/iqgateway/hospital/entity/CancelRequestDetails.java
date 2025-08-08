package training.iqgateway.hospital.entity;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;

@Data
public class CancelRequestDetails {
	private String staffId;
	private String date;
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private String from;
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private String to;
	private String hospitalId;
	private String status = "cancelled";
}