package training.iqgateway.dto;

import java.util.List;

import training.iqgateway.entity.Address;
import training.iqgateway.entity.ContactDetails;
import training.iqgateway.entity.LeaveDetail;
import training.iqgateway.entity.WorkSchedule;
import training.iqgateway.entity.WorkingHour;

public class NurseResponseDTO {
	
    private String _id;
    private String userId;
    private String firstName;
    private String lastName;
    private boolean availableStatus;
    private List<LeaveDetail> leaveDetails;
    private ContactDetails contactDetails;
    private String certificate;
    private Integer yearOfExperience;
    public Integer getYearOfExperience() {
		return yearOfExperience;
	}

	public void setYearOfExperience(Integer yearOfExperience) {
		this.yearOfExperience = yearOfExperience;
	}

	private String certificateNumber;
    private Address address;
    private boolean currentWorkingStatus;
    private List<WorkingHour> workingHours;
    private List<WorkSchedule> workSchedule;
    private List<String> skills;
    private String selfDescription;
    private String registrationStatus;

    // Constructors
    public NurseResponseDTO() {}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean isAvailableStatus() {
		return availableStatus;
	}

	public void setAvailableStatus(boolean availableStatus) {
		this.availableStatus = availableStatus;
	}

	public List<LeaveDetail> getLeaveDetails() {
		return leaveDetails;
	}

	public void setLeaveDetails(List<LeaveDetail> leaveDetails) {
		this.leaveDetails = leaveDetails;
	}

	public ContactDetails getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(ContactDetails contactDetails) {
		this.contactDetails = contactDetails;
	}

	public String getCertificate() {
		return certificate;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}

	public String getCertificateNumber() {
		return certificateNumber;
	}

	public void setCertificateNumber(String certificateNumber) {
		this.certificateNumber = certificateNumber;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public boolean isCurrentWorkingStatus() {
		return currentWorkingStatus;
	}

	public void setCurrentWorkingStatus(boolean currentWorkingStatus) {
		this.currentWorkingStatus = currentWorkingStatus;
	}

	public List<WorkingHour> getWorkingHours() {
		return workingHours;
	}

	public void setWorkingHours(List<WorkingHour> workingHours) {
		this.workingHours = workingHours;
	}

	public List<WorkSchedule> getWorkSchedule() {
		return workSchedule;
	}

	public void setWorkSchedule(List<WorkSchedule> workSchedule) {
		this.workSchedule = workSchedule;
	}

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	public String getSelfDescription() {
		return selfDescription;
	}

	public void setSelfDescription(String selfDescription) {
		this.selfDescription = selfDescription;
	}

	public String getRegistrationStatus() {
		return registrationStatus;
	}

	public void setRegistrationStatus(String registrationStatus) {
		this.registrationStatus = registrationStatus;
	}

	
	
	
	public NurseResponseDTO(String _id, String userId, String firstName, String lastName,
			boolean availableStatus, List<LeaveDetail> leaveDetails, ContactDetails contactDetails, String certificate,
			Integer yearOfExperience, String certificateNumber, Address address, boolean currentWorkingStatus,
			List<WorkingHour> workingHours, List<WorkSchedule> workSchedule, List<String> skills,
			String selfDescription, String registrationStatus) {
		super();
		this._id = _id;
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.availableStatus = availableStatus;
		this.leaveDetails = leaveDetails;
		this.contactDetails = contactDetails;
		this.certificate = certificate;
		this.yearOfExperience = yearOfExperience;
		this.certificateNumber = certificateNumber;
		this.address = address;
		this.currentWorkingStatus = currentWorkingStatus;
		this.workingHours = workingHours;
		this.workSchedule = workSchedule;
		this.skills = skills;
		this.selfDescription = selfDescription;
		this.registrationStatus = registrationStatus;
	}

	public NurseResponseDTO(String _id, String userId, String firstName, String lastName,
			boolean availableStatus, List<LeaveDetail> leaveDetails, ContactDetails contactDetails, String certificate,
			String certificateNumber, Address address, boolean currentWorkingStatus, List<WorkingHour> workingHours,
			List<WorkSchedule> workSchedule, List<String> skills, String selfDescription, String registrationStatus) {
		super();
		this._id = _id;
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.availableStatus = availableStatus;
		this.leaveDetails = leaveDetails;
		this.contactDetails = contactDetails;
		this.certificate = certificate;
		this.certificateNumber = certificateNumber;
		this.address = address;
		this.currentWorkingStatus = currentWorkingStatus;
		this.workingHours = workingHours;
		this.workSchedule = workSchedule;
		this.skills = skills;
		this.selfDescription = selfDescription;
		this.registrationStatus = registrationStatus;
	}

	@Override
	public String toString() {
		return "NurseRegistrationResponseDTO [_id=" + _id + ", userId=" + userId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", availableStatus=" + availableStatus + ", leaveDetails=" + leaveDetails
				+ ", contactDetails=" + contactDetails + ", certificate=" + certificate + ", yearOfExperience="
				+ yearOfExperience + ", certificateNumber=" + certificateNumber + ", address=" + address
				+ ", currentWorkingStatus=" + currentWorkingStatus + ", workingHours=" + workingHours
				+ ", workSchedule=" + workSchedule + ", skills=" + skills + ", selfDescription=" + selfDescription
				+ ", registrationStatus=" + registrationStatus + "]";
	}

	
    

    // Getters and Setters for all fields...
}