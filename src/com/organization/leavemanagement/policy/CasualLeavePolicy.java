package com.organization.leavemanagement.policy;

import com.organization.leavemanagement.exception.InsufficientLeaveBalanceException;
import com.organization.leavemanagement.model.Employee;
import com.organization.leavemanagement.model.LeaveStatus;
import com.organization.leavemanagement.model.Leaverequest;

public class CasualLeavePolicy implements LeavePolicy{
    @Override
    public void validateLeave(Employee employee, Leaverequest leaverequest) throws InsufficientLeaveBalanceException{
        if(leaverequest.getNumberOfDays() >3){
            leaverequest.setLeaveStatus(LeaveStatus.REJECTED);
            System.out.println(leaverequest.getLeaveStatus());
            throw new InsufficientLeaveBalanceException("Casual leave cannot exceed 3 days");
        }
    }
}
