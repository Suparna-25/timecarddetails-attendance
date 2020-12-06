package com.cg.attendance.services;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.attendance.dto.AttendanceDto;
import com.cg.attendance.entities.AttendanceDetail;
import com.cg.attendance.exception.AttendanceIDException;
import com.cg.attendance.repositories.AttendanceDetailRepository;

@SpringBootTest
class AttendanceDetailServiceTest {
@MockBean
AttendanceDetailRepository attendanceReop;

@Autowired
AttendanceDetailService attendanceService;
	@Test
	void testAddAttendanceDetail() throws Exception {
		
		AttendanceDto attendanceDto=new AttendanceDto("326",null,null,null, null,"approve",null);
		AttendanceDetail attendance=new AttendanceDetail(attendanceDto.getInTime(),attendanceDto.getOutTime(),
				attendanceDto.getAttendanceDate(),attendanceDto.getReason(),attendanceDto.getTypeId(),attendanceDto.getStatus(),
				null);
		Mockito.when(attendanceReop.save(attendance)).thenReturn(attendance);
		AttendanceDetail newAttendance=attendanceService.addAttendanceDetail(attendanceDto);
		assertEquals(attendance.getId(),newAttendance.getId());
		
	}
	@Test
	void testAttendaceAlreadyExists() throws Exception{
		AttendanceDto attendanceDto=new AttendanceDto("326",null,null,null, null,"approve",null);
		AttendanceDetail attendance=new AttendanceDetail(attendanceDto.getInTime(),attendanceDto.getOutTime(),
				attendanceDto.getAttendanceDate(),attendanceDto.getReason(),attendanceDto.getTypeId(),attendanceDto.getStatus(),
				null);
		BDDMockito.given(attendanceService.addAttendanceDetail(attendanceDto)).willThrow(new AttendanceIDException());
		assertThrows(AttendanceIDException.class,()->attendanceService.addAttendanceDetail(attendanceDto));
	}
//	@Test
//	void testUpdateAttendanceStatus()throws Exception{
//		AttendanceDto attendanceDto=new AttendanceDto("326",null,null,null, null,"approve",null);
//		AttendanceDetail attendance=new AttendanceDetail(attendanceDto.getInTime(),attendanceDto.getOutTime(),
//				attendanceDto.getAttendanceDate(),attendanceDto.getReason(),attendanceDto.getTypeId(),attendanceDto.getStatus(),
//				null);
//		Long id=attendance.getId();
//		Optional<AttendanceDetail> detail =attendance;
//		Mockito.when(attendanceReop.findById(id)).thenReturn(detail);		
//		attendance.setStatus("Approve");
//		assertEquals("Approve",attendance.getStatus());
//	}
//	@Test
//	void testAttendaceNotFoundException() throws Exception{
//		BDDMockito.given(attendanceReop.findByAttendanceId("234")).willThrow(new AttendanceIDException());
//		assertThrows(AttendanceIDException.class,()->attendanceReop.findByAttendanceId("234"));
//	}
//	@Test
//	void testViewAttendanceByAttendanceId() throws Exception{
//		AttendanceDetail attendance=new AttendanceDetail("326",null,null,null, null,"pending",null);
//		String attendanceId=attendance.getAttendanceId();
//		Mockito.when(attendanceReop.findByAttendanceId(attendanceId)).thenReturn(attendance);
//		assertEquals(attendanceId,attendanceService.viewAttendanceByAttendanceId(attendanceId).getAttendanceId());
//	}
}
