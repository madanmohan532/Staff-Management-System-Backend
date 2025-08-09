package training.iqgateway.staff;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import training.iqgateway.staff.controller.NurseController;
import training.iqgateway.staff.entity.ClockInRequest;
import training.iqgateway.staff.entity.ClockOutRequest;
import training.iqgateway.staff.entity.HospitalNurse;
import training.iqgateway.staff.entity.LeaveDetail;
import training.iqgateway.staff.entity.Nurse;
import training.iqgateway.staff.entity.Patient;
import training.iqgateway.staff.entity.RemoveHospitalNurse;
import training.iqgateway.staff.entity.RequestResponse;
import training.iqgateway.staff.repository.NurseRepository;
import training.iqgateway.staff.service.NurseService;
import training.iqgateway.staff.service.PatientService;

class NurseControllerTest {

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @Mock
    private NurseService nurseService;
    @Mock
    private RestTemplate restTemplate;
    @Mock
    private PatientService patientService;
    @Mock
    private NurseRepository nurseRepository; // needed for constructor injection

    @InjectMocks
    private NurseController nurseController;

    private AutoCloseable closeable;

    @BeforeEach
    void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
        nurseController = new NurseController(nurseRepository); // constructor param
        // inject mocks (fields) manually for completeness
        nurseController.nurseService = nurseService;
        nurseController.restTemplate = restTemplate;
        nurseController.patientService = patientService;
        mockMvc = MockMvcBuilders.standaloneSetup(nurseController).build();
        objectMapper = new ObjectMapper();
    }

    @AfterEach
    void tearDown() throws Exception {
        closeable.close();
    }

    // Sample builders -----------------
    private Nurse createNurse() {
        Nurse nurse = new Nurse();
        nurse.set_id("N1");
        nurse.setFirstName("Alice");
        nurse.setLastName("Doe");
        nurse.setAvailableStatus(true);
        return nurse;
    }

    private Patient createPatient() {
        Patient p = new Patient();
        p.setId("P1");
        p.setFirstName("John");
        p.setLastName("Smith");
        return p;
    }

    private HospitalNurse createHospitalNurseWithPatients(List<String> ids) {
        HospitalNurse hn = new HospitalNurse();
        hn.setStaffId("N1");
        hn.setPatientsAllocatedTo(ids);
        return hn;
    }

    private ClockInRequest createClockInRequest() {
        ClockInRequest req = new ClockInRequest();
        req.setNurseId("N1");
        req.setHospitalId("H1");
        req.setClockInTime("2024-08-09T09:00");
        req.setDate("2024-08-09");
        req.setTo("2024-08-09T17:00");
        return req;
    }

    // Basic endpoint tests ------------

    @Test
    void testGetNurseDetails_success() throws Exception {
        when(nurseService.getNurseById("N1")).thenReturn(createNurse());
        mockMvc.perform(get("/api/nurse/N1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("Alice"));
    }

    @Test
    void testGetNurseDetails_notFound() throws Exception {
        when(nurseService.getNurseById("N2")).thenThrow(new RuntimeException("Not found"));
        mockMvc.perform(get("/api/nurse/N2"))
                .andExpect(status().isNotFound())
                .andExpect(content().string("Nurse not found with id: N2"));
    }

    @Test
    void testGetNurseDetailsByEmail_success() throws Exception {
        when(nurseService.getNurseByEmail("alice@example.com")).thenReturn(createNurse());
        mockMvc.perform(get("/api/nurse/getNurse/alice@example.com"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("Alice"));
    }

    @Test
    void testGetNurseDetailsByEmail_notFound() throws Exception {
        when(nurseService.getNurseByEmail("unknown@example.com")).thenThrow(new RuntimeException("Not found"));
        mockMvc.perform(get("/api/nurse/getNurse/unknown@example.com"))
                .andExpect(status().isNotFound())
                .andExpect(content().string("Nurse not found with email: unknown@example.com"));
    }

    @Test
    void testUpdateNurseDetails_success() throws Exception {
        Nurse nurse = createNurse();
        when(nurseService.updateNurse(any(Nurse.class))).thenReturn(nurse);

        mockMvc.perform(put("/api/nurse/updateNurse/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(nurse)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("Alice"));
    }

    @Test
    void testUpdateNurseDetails_error() throws Exception {
        Nurse nurse = createNurse();
        when(nurseService.updateNurse(any(Nurse.class)))
                .thenThrow(new RuntimeException("Database failure"));

        mockMvc.perform(put("/api/nurse/updateNurse/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(nurse)))
                .andExpect(status().isInternalServerError())
                .andExpect(content().string("Error updating nurse details: Database failure"));
    }

    @Test
    void testSetNurseAvailability_success() throws Exception {
        Nurse nurse = createNurse();
        nurse.setAvailableStatus(false);
        when(nurseService.setNurseAvailability("N1", false)).thenReturn(nurse);

        mockMvc.perform(put("/api/nurse/setAvailability/N1/false"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.availableStatus").value(false));
    }

    @Test
    void testSetNurseAvailability_error() throws Exception {
        when(nurseService.setNurseAvailability("N2", true))
            .thenThrow(new RuntimeException("Bad nurseId"));

        mockMvc.perform(put("/api/nurse/setAvailability/N2/true"))
                .andExpect(status().isInternalServerError())
                .andExpect(content().string("Error setting nurse availability: Bad nurseId"));
    }

    @Test
    void testGetPatientDetails_success() throws Exception {
        // HospitalNurse with allocated patients: ["P1", "P2"]
        HospitalNurse hn = createHospitalNurseWithPatients(Arrays.asList("P1", "P2"));
        when(restTemplate.getForObject(anyString(), eq(HospitalNurse.class))).thenReturn(hn);
        Patient p1 = createPatient(); p1.setId("P1");
        Patient p2 = createPatient(); p2.setId("P2");
        p2.setFirstName("Jane"); p2.setId("P2");

        when(patientService.getPatientById("P1")).thenReturn(p1);
        when(patientService.getPatientById("P2")).thenReturn(p2);

        mockMvc.perform(get("/api/nurse/getPatientDetails/N1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value("P1"))
                .andExpect(jsonPath("$[1].id").value("P2"));
    }

    @Test
    void testGetPatientDetailsByHospitalId_success() throws Exception {
        when(patientService.getPatientsByHospitalId("H1")).thenReturn(List.of(createPatient()));
        mockMvc.perform(get("/api/nurse/getPatientDetailsByHospitalId/H1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].firstName").value("John"));
    }

    @Test
    void testGetPatientDetailsById_success() throws Exception {
        when(patientService.getPatientById("P1")).thenReturn(createPatient());
        mockMvc.perform(get("/api/nurse/getPatientDetailsById/P1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Patient details for patient with ID: P1"));
    }

    @Test
    void testClockIn_success() throws Exception {
        ClockInRequest req = createClockInRequest();
        Nurse nurse = createNurse();
        when(nurseService.clockIn(any(ClockInRequest.class))).thenReturn(nurse);

        mockMvc.perform(post("/api/nurse/clockIn")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(req)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("Alice"));
    }

    @Test
    void testClockIn_notFound() throws Exception {
        ClockInRequest req = createClockInRequest();
        when(nurseService.clockIn(any(ClockInRequest.class))).thenReturn(null);

        mockMvc.perform(post("/api/nurse/clockIn")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(req)))
                .andExpect(status().isNotFound())
                .andExpect(content().string("Nurse not Found"));
    }

    @Test
    void testClockOut_success() throws Exception {
        ClockOutRequest req = new ClockOutRequest();
        Nurse nurse = createNurse();
        when(nurseService.clockOut(any(ClockOutRequest.class))).thenReturn(nurse);

        mockMvc.perform(post("/api/nurse/clockOut")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(req)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("Alice"));
    }

    @Test
    void testClockOut_notFound() throws Exception {
        ClockOutRequest req = new ClockOutRequest();
        when(nurseService.clockOut(any(ClockOutRequest.class))).thenReturn(null);

        mockMvc.perform(post("/api/nurse/clockOut")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(req)))
                .andExpect(status().isNotFound())
                .andExpect(content().string("Nurse not Found"));
    }

    @Test
    void testApplyLeaveForNurse_success() throws Exception {
        LeaveDetail ld = new LeaveDetail();
        ld.setFrom("2024-08-09T09:00");
        ld.setTo("2024-08-09T17:00");
        ld.setNurseId("N1");

        doNothing().when(nurseService).applyLeave(any(LeaveDetail.class));
        mockMvc.perform(put("/api/nurse/applyLeave")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(ld)))
                .andExpect(status().isOk())
                .andExpect(content().string("Leave Applied Successfully"));
    }

    @Test
    void testUpdatePatientDetails_success() throws Exception {
        Patient p = createPatient();
        when(patientService.updatePatient(any(Patient.class))).thenReturn(p);

        mockMvc.perform(put("/api/nurse/updatePatientDetails")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(p)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("John"));
    }

    @Test
    void testUpdatePatientDetails_error() throws Exception {
        Patient p = createPatient();
        when(patientService.updatePatient(any(Patient.class)))
            .thenThrow(new RuntimeException("Update failed"));

        mockMvc.perform(put("/api/nurse/updatePatientDetails")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(p)))
                .andExpect(status().isInternalServerError())
                .andExpect(content().string("Error updating patient details: Update failed"));
    }

    @Test
    void testGetWorkingHoursOfNurse_success() throws Exception {
        Nurse.WorkingHour wh = new Nurse.WorkingHour("2024-08-09", "09:00", "17:00", "H1");
        when(nurseService.getWorkingHours("N1")).thenReturn(List.of(wh));

        mockMvc.perform(get("/api/nurse/getWorkingHours/N1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].hospitalId").value("H1"));
    }

    @Test
    void testGetWorkSchedule_success() throws Exception {
        Nurse.WorkSchedule ws = new Nurse.WorkSchedule();
        ws.setDate("2024-08-09");
        ws.setFrom("09:00");
        ws.setTo("17:00");
        ws.setHospitalId("H1");
        ws.setStatus("accepted");

        when(nurseService.getWorkingSchedule("N1")).thenReturn(List.of(ws));

        mockMvc.perform(get("/api/nurse/getWorkSchedule/N1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].status").value("accepted"));
    }

    @Test
    void testRespondToHospitalRequest_accepted() throws Exception {
        RequestResponse req = new RequestResponse();
        req.setStatus("accepted");
        req.setNurseId("N1");
        req.setFrom("09:00");
        req.setTo("17:00");
        req.setHospitalId("H1");
        req.setDate("2024-08-09");

        Nurse nurse = createNurse();
        when(nurseService.respondToRequest(any(RequestResponse.class))).thenReturn(nurse);

        // skip RestTemplate side effect, just verify result
        mockMvc.perform(put("/api/nurse/responseToHospitalRequest")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(req)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("Alice"));
    }

    @Test
    void testRespondToHospitalRequest_notAccepted() throws Exception {
        RequestResponse req = new RequestResponse();
        req.setStatus("pending"); // anything but "accepted"
        when(nurseService.respondToRequest(any(RequestResponse.class))).thenReturn(createNurse());

        mockMvc.perform(put("/api/nurse/responseToHospitalRequest")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(req)))
                .andExpect(status().isNotFound())
                .andExpect(content().string("nothing "));
    }

    @Test
    void testRejectHospitalRequest_rejected() throws Exception {
        RequestResponse req = new RequestResponse();
        req.setStatus("rejected");
        req.setNurseId("N1"); req.setFrom("09:00"); req.setTo("17:00"); req.setHospitalId("H1");
        Nurse nurse = createNurse();
        when(nurseService.rejectRequest(any(RequestResponse.class))).thenReturn(nurse);

        mockMvc.perform(put("/api/nurse/rejectToHospitalRequest")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(req)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nurseId").value("N1"));
    }

    @Test
    void testRejectHospitalRequest_notRejected() throws Exception {
        RequestResponse req = new RequestResponse();
        req.setStatus("pending"); // not "rejected"
        when(nurseService.rejectRequest(any(RequestResponse.class))).thenReturn(createNurse());

        mockMvc.perform(put("/api/nurse/rejectToHospitalRequest")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(req)))
                .andExpect(status().isNotAcceptable())
                .andExpect(content().string("Cannot delete nurse requst"));
    }

    @Test
    void testRemoveNurse_success() throws Exception {
        RemoveHospitalNurse remove = new RemoveHospitalNurse();
        remove.setNurseId("N1");
        Nurse nurse = createNurse();
        when(nurseService.removeNurse(any(RemoveHospitalNurse.class))).thenReturn(nurse);

        mockMvc.perform(put("/api/nurse/removeNurse")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(remove)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("Alice"));
    }
}
