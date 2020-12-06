package com.cg.attendance.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.attendance.entities.AttendanceDetail;
/**
 * This a Attendance Details repository that performs all the crud operation on employee attendance details
 * @author Suparna Arya & Aswitha 
 *
 */
@Repository
public interface AttendanceDetailRepository extends CrudRepository<AttendanceDetail, Long>
{
			public AttendanceDetail findByAttendanceId(String attendanceId);
			
			

}