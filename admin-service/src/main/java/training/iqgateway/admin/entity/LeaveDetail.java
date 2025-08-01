package training.iqgateway.admin.entity;

public class LeaveDetail {
	private String fromDate;
    private String toDate;

    // Constructors, Getters and Setters
    public LeaveDetail() {}

    public LeaveDetail(String fromDate, String toDate) {
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public String getFromDate() { return fromDate; }
    public void setFromDate(String fromDate) { this.fromDate = fromDate; }
    public String getToDate() { return toDate; }
    public void setToDate(String toDate) { this.toDate = toDate; }

	@Override
	public String toString() {
		return "LeaveDetail [fromDate=" + fromDate + ", toDate=" + toDate + "]";
	}
    
    
}
