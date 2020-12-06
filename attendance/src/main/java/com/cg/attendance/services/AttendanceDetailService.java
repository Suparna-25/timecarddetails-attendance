package com.cg.attendance.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.attendance.entities.AttendanceDetail;
import com.cg.attendance.exception.AttendanceIDException;
import com.cg.attendance.repositories.AttendanceDetailRepository;

@Service
public class AttendanceDetailService implements IAttendanceDetailService {
	@Autowired
	private AttendanceDetailRepository attendanceRepo;

	@Override
	public AttendanceDetail addAttendanceDetail(AttendanceDetail attendance) {
		try {
		attendance.setAttendanceId(attendance.getAttendanceId());		
		return attendanceRepo.save(attendance);
		}catch(Exception ex)
		{
			throw new AttendanceIDException("attendance id "+attendance.getAttendanceId()+" is already present");
		}

	}

	@Override
	public AttendanceDetail updateAttendanceStatus(String attendanceId, AttendanceDetail attendance) {
				AttendanceDetail newAttendance = attendanceRepo.findByAttendanceId(attendanceId);
				if(newAttendance==null)
				{   
					 
					throw new AttendanceIDException("No attendance is added for attendance id "+attendanceId);
				}
			     if(newAttendance.getStatus().equalsIgnoreCase("pending"))
				 {
			     newAttendance.setStatus(attendance.getStatus());
				 } 
				 else
				 {
					 newAttendance.setStatus(newAttendance.getStatus());
				 }
			     return attendanceRepo.save(newAttendance);
			    
	  }

	@Override
	public AttendanceDetail viewAttendanceByAttendanceId(String attendanceId) {
		AttendanceDetail newAttendance=attendanceRepo.findByAttendanceId(attendanceId);
		if(newAttendance==null)
		{
			throw new AttendanceIDException("No attendance is added for attendance id "+attendanceId);
		}
		return newAttendance;
	}

}