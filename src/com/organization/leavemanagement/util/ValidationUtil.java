package com.organization.leavemanagement.util;

import com.organization.leavemanagement.exception.InvalidLeaveRequestException;
import com.organization.leavemanagement.model.LeaveType;

import java.time.LocalDate;

public class ValidationUtil {
    public ValidationUtil() {
    }
    public static void validateId(String id) throws InvalidLeaveRequestException {
        if(id==null || id.trim().isEmpty()){
            throw new InvalidLeaveRequestException("Id cannot be empty");
        }
    }
    public static void validateReason(String reason) throws InvalidLeaveRequestException{
        if(reason == null || reason.trim().isEmpty()){
            throw new InvalidLeaveRequestException("reason should not be empty");
        }
    }
    public static void validateDays(int days) throws InvalidLeaveRequestException{
        if(days<=0){
            throw new InvalidLeaveRequestException("Leave days cannot be below 1");
        }

    }
    public static void validateDate(LocalDate date) throws InvalidLeaveRequestException{
        if(date == null){
            throw new InvalidLeaveRequestException("date of leave request cannot be null");
        }
    }
    public static void validateLeaveType(LeaveType e) throws InvalidLeaveRequestException{
        if(e==null){
            throw new InvalidLeaveRequestException("leave type cannot be null");
        }
    }



}
