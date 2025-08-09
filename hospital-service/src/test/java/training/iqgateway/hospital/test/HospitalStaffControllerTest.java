package training.iqgateway.hospital.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import training.iqgateway.hospital.controller.HospitalStaffController;
import training.iqgateway.hospital.entity.*;

import training.iqgateway.hospital.service.HospitalNurseService;

import java.util.*;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class HospitalStaffControllerTest {

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @Mock HospitalNurseService hospitalNurseService;
    @Mock RestTemplate restTemplate;

    @InjectMocks
    private HospitalStaffController controller;

    AutoCloseable closeable;

    @BeforeEach
    void setup() {
        closeable = MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        objectMapper = new ObjectMapper();
    }
    @AfterEach
    void tearDown() throws Exception { closeable.close(); }

    HospitalNurse createHospitalNurse() {
        HospitalNurse h = new HospitalNurse();
        h.setHospitalStaffId("HS1");
        h.setHospitalId("H1");
        h.setStaffId("N1");
        return h;
    }

    @Test
    void testGetHospitalNurseDetails_success() throws Exception {
        when(hospitalNurseService.getAllHospitalNurses()).thenReturn(List.of(createHospitalNurse()));
        mockMvc.perform(get("/api/hospital/nurse/getHospitalNurseDetails"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].hospitalStaffId").value("HS1"));
    }

    @Test
    void testCreateHospitalNurse_success() throws Exception {
        mockMvc.perform(post("/api/hospital/nurse/createHospitalNurse")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createHospitalNurse())))
                .andExpect(status().isCreated());
        verify(hospitalNurseService).createHospitalNurse(any(HospitalNurse.class));
    }

    @Test
    void testChangeWorkingStatus_notFound() throws Exception {
        when(hospitalNurseService.changeWorkingStatus("HS1", true)).thenReturn(null);
        mockMvc.perform(put("/api/hospital/nurse/changeWorkingStatus")
                        .param("hospitalStaffId", "HS1")
                        .param("workingStatus", "true"))
                .andExpect(status().isNotFound());
    }

    @Test
    void testAssignNurseToFloor_success() throws Exception {
        when(hospitalNurseService.assignNurseToFloor("F1", "HS1")).thenReturn(true);
        mockMvc.perform(put("/api/hospital/nurse/assignNurseToFloor")
                        .param("floor", "F1")
                        .param("hospitalStaffId", "HS1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Floor Updated Successfully"));
    }

    @Test
    void testGetHospitalNurseByStaffId_found() throws Exception {
        when(hospitalNurseService.getHospitalNurseByStaffId("N1")).thenReturn(createHospitalNurse());
        mockMvc.perform(get("/api/hospital/nurse/getHospitalNurseByStaffId/N1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.staffId").value("N1"));
    }

    @Test
    void testGetHospitalNursesByHospitalId_found() throws Exception {
        when(hospitalNurseService.getHospitalNurseByHospitalId("H1"))
                .thenReturn(List.of(createHospitalNurse()));
        mockMvc.perform(get("/api/hospital/nurse/hospitalNurses").param("hospitalId", "H1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].hospitalId").value("H1"));
    }

    @Test
    void testRemoveHospitalNurse_success() throws Exception {
        RemoveHospitalNurse removeReq = new RemoveHospitalNurse();
        removeReq.setHospitalStaffId("HS1");
        when(hospitalNurseService.removeHospitalNurse("HS1")).thenReturn(createHospitalNurse());
        mockMvc.perform(put("/api/hospital/nurse/removeHospitalNurse")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(removeReq)))
                .andExpect(status().isOk());
    }
}
