package com.cg.attendance.controllers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.cg.attendance.entities.AttendanceDetail;
import com.cg.attendance.entities.Employee;
import com.cg.attendance.exception.AttendanceIDException;
import com.cg.attendance.services.AttendanceDetailService;


@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = AttendanceDetailController.class)
class AttendanceDetailControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	AttendanceDetailService attendanceService;
    @Test
	void testAddNewAttendance() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/api/attendanceapplication/add-attendance"))
		.andExpect(status().isOk());
//		.andExpect(jsonPath("$").isMap())
//		.andExpect(jsonPath("attendanceId").value("1"))
//		.andExpect(jsonPath("inTime").value("8:30"))
//		.andExpect(jsonPath("status").value("Pending"));
	}

}
