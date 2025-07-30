package training.iqgateway.staff.entity;

import java.time.Instant;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "hospital_staff_details")
public class HospitalNurse {
	@Id
    @Field("_id")
    private String id;

    @Field("hospital_staff_id")
    private String hospitalStaffId;

    @Field("staff_id")
    private String staffId;

    @Field("staff_request_status")
    private String staffRequestStatus;

    @Field("hospital_id")
    private String hospitalId;

    @Field("patients_allocated_to")
    private List<String> patientsAllocatedTo;

    @Field("available_from")
    private Instant availableFrom;

    @Field("available_upto")
    private Instant availableUpto;

    @Field("replaced_by")
    private String replacedBy;

    @Field("floor_assigned")
    private String floorAssigned;

    @Field("requested_on")
    private Instant requestedOn;

    @Field("accepted_on")
    private Instant acceptedOn;

    @Field("requested_from")
    private Instant requestedFrom;

    @Field("requested_upto")
    private Instant requestedUpto;

    @Field("working_hours_with_hospital")
    private List<WorkingHours> workingHoursWithHospital;

    @Field("working_status")
    private boolean workingStatus;

    @Data
    public static class WorkingHours {
        @Field("from")
        private Instant from;
        
        @Field("to")
        private Instant to;
    }
}
