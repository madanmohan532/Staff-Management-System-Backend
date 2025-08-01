package training.iqgateway.admin.entity;

import lombok.Data;

@Data
public class WorkSchedule {
    private String date;
    private String from;
    private String to;
    private String hospitalId;
    private String status; // "confirmed", "pending", "cancelled"

    // Constructors, Getters and Setters
    public WorkSchedule() {}

    public WorkSchedule(String date, String from, String to, String hospitalId, String status) {
        this.date = date;
        this.from = from;
        this.to = to;
        this.hospitalId = hospitalId;
        this.status = status;
    }

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "WorkSchedule [date=" + date + ", from=" + from + ", to=" + to + ", hospitalId=" + hospitalId
				+ ", status=" + status + "]";
	}

    // Getters and Setters...
}