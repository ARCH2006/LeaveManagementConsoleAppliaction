package com.organization.leavemanagement.policy;

import com.organization.leavemanagement.exception.InsufficientLeaveBalanceException;

import com.organization.leavemanagement.model.Employee;
import com.organization.leavemanagement.model.Leaverequest;

public interface LeavePolicy {
    void validateLeave(Employee employee, Leaverequest leaverequest) throws InsufficientLeaveBalanceException;
}
