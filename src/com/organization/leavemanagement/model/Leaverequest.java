package com.organization.leavemanagement.model;

import java.time.LocalDate;

public class Leaverequest {
    private String employeeId;
    private LeaveType leaveType;
    private int numberOfDays;
    private String reason;
    private LocalDate requestDate;
    private LeaveStatus leaveStatus = LeaveStatus.PENDING;


    public Leaverequest(String employeeId, LeaveType leaveType, int numberOfDays,String reason,LocalDate requestDate) {
        this.employeeId = employeeId;
        this.leaveType = leaveType;
        this.numberOfDays = numberOfDays;
        this.reason = reason;
        this.requestDate = requestDate;

    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public LeaveType getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(LeaveType leaveType) {
        this.leaveType = leaveType;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDate requestDate) {
        this.requestDate = requestDate;
    }
    public LeaveStatus getLeaveStatus(){
        return leaveStatus;
    }
    public void setLeaveStatus(LeaveStatus status){
        this.leaveStatus = status;
    }


}
