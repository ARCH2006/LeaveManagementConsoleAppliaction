package com.organization.leavemanagement.policy;

import com.organization.leavemanagement.exception.InsufficientLeaveBalanceException;
import com.organization.leavemanagement.model.Employee;
import com.organization.leavemanagement.model.LeaveStatus;
import com.organization.leavemanagement.model.Leaverequest;

public class EarnedLeavePolicy implements LeavePolicy{
    @Override
    public void validateLeave(Employee employee, Leaverequest r) throws InsufficientLeaveBalanceException{
        if(r.getNumberOfDays() > 6){
            r.setLeaveStatus(LeaveStatus.REJECTED);
            System.out.println(r.getLeaveStatus());
            throw new InsufficientLeaveBalanceException("Earned leave cannot be exceeded 6 days");
        }
    }

}
