package com.organization.leavemanagement.policy;

import com.organization.leavemanagement.exception.InsufficientLeaveBalanceException;
import com.organization.leavemanagement.model.Employee;
import com.organization.leavemanagement.model.LeaveStatus;
import com.organization.leavemanagement.model.Leaverequest;

public class SickLeavePolicy implements LeavePolicy {
    @Override
    public void validateLeave(Employee employee, Leaverequest leaverequest) throws InsufficientLeaveBalanceException{
        if(leaverequest.getNumberOfDays() > 5){
            leaverequest.setLeaveStatus(LeaveStatus.REJECTED);
            System.out.println(leaverequest.getLeaveStatus());
            throw new InsufficientLeaveBalanceException("Sick leave cannot be exceed 5 days");
        }
    }
}
