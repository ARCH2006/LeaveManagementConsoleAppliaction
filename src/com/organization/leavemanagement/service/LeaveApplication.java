package com.organization.leavemanagement.service;

import com.organization.leavemanagement.exception.EmployeeNotFoundException;
import com.organization.leavemanagement.exception.InsufficientLeaveBalanceException;
import com.organization.leavemanagement.exception.InvalidLeaveRequestException;
import com.organization.leavemanagement.model.Employee;
import com.organization.leavemanagement.model.LeaveStatus;
import com.organization.leavemanagement.model.LeaveType;
import com.organization.leavemanagement.model.Leaverequest;
import com.organization.leavemanagement.policy.CasualLeavePolicy;
import com.organization.leavemanagement.policy.EarnedLeavePolicy;
import com.organization.leavemanagement.policy.LeavePolicy;
import com.organization.leavemanagement.policy.SickLeavePolicy;
import com.organization.leavemanagement.repository.EmployeeRepository;
import com.organization.leavemanagement.util.ValidationUtil;

public class LeaveApplication {
    private LeavePolicy leavePolicy;
    private EmployeeRepository repository;
    public LeaveApplication(EmployeeRepository repository){
        this.repository = repository;
    }
    public void applyLeave(Leaverequest request) throws InvalidLeaveRequestException, EmployeeNotFoundException, InsufficientLeaveBalanceException {
        ValidationUtil.validateId(request.getEmployeeId());
        ValidationUtil.validateLeaveType(request.getLeaveType());
        ValidationUtil.validateDays(request.getNumberOfDays());
        ValidationUtil.validateReason(request.getReason());
        ValidationUtil.validateDate(request.getRequestDate());
        if(!repository.exists(request.getEmployeeId())){
            throw new EmployeeNotFoundException("employee not found");
        }
        Employee employee = repository.fetchEmployeeById(request.getEmployeeId());
        if(request.getNumberOfDays() > employee.getLeaveBalance()){
            throw new InsufficientLeaveBalanceException("insufficient leave balance");
        }
//        if(request.getNumberOfDays()>5 && request.getLeaveType() == LeaveType.SICK){
//            throw new InvalidLeaveRequestException("sick leave cannot exceed 5 days");
//
//        }
//        if(employee.getYearlyAvailableLeave() + request.getNumberOfDays() > 20){
//            throw new InvalidLeaveRequestException("yearly leave exceeded");
//        }
        if(employee.getYearlyAvailableLeave() + request.getNumberOfDays() > employee.calculateMaxLeave() ){
            throw new InvalidLeaveRequestException("Yearly leave limit exceeded");

        }
        switch(request.getLeaveType()){
            case SICK:
                leavePolicy = new SickLeavePolicy();
                break;
            case EARNED:
                leavePolicy = new EarnedLeavePolicy();
                break;
            case CASUAL:
                leavePolicy = new CasualLeavePolicy();
                break;
            default:
                throw new InvalidLeaveRequestException("not belongs to any leave type(SICK/EARNED/CASUAL)");

        }
        leavePolicy.validateLeave(employee,request);
        employee.setLeaveBalance(employee.getLeaveBalance() - request.getNumberOfDays());
        employee.addYearlyRequestedLeave(request.getNumberOfDays());
        request.setLeaveStatus(LeaveStatus.APPROVED);
        System.out.println(request.getLeaveStatus());

    }
}
