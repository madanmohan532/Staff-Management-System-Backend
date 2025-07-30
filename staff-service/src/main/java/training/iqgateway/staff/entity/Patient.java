package training.iqgateway.staff.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "patients_details")
public class Patient {
    @Id
    private String id;
    
    @Field("patient_id")
    private String patientId;
    
    @Field("first_name")
    private String firstName;
    
    @Field("last_name")
    private String lastName;
    
    @Field("admit_date")
    private String admitDate;
    
    @Field("expected_discharge_date")
    private String expectedDischargeDate;
    
    @Field("actual_discharge_date")
    private String actualDischargeDate;
    
    @Field("associated_doctor")
    private String associatedDoctor;
    
    @Field("staff_id")
    private String staffId;
    
    @Field("hospital_id")
    private String hospitalId;
    
    @Field("floor_number")
    private String floorNumber;
    
    private Address address;
    private MedicalInformation medicalInformation;

    @Data
    public static class Address {
        private String street;
        private String city;
        private String state;
        private String pincode;
    }

    @Data
    public static class MedicalInformation {
        @Field("primary_reason")
        private String primaryReason;
        
        @Field("secondary_reason")
        private String secondaryReason;
        
        private String treatment;
        
        @Field("last_consulted_at")
        private String lastConsultedAt;
        
        private Medicines medicines;
    }

    @Data
    public static class Medicines {
        private List<String> tablets;
        private List<String> injections;
        private List<String> tests;
    }
}