package com.organization.leavemanagement.model;

public abstract class Employee {
    private String employeeId;
    private String name;
    protected int leaveBalance;
    private int yearlyAvailableLeave;

    public Employee(String employeeId, String name, int leaveBalance) {
        this.employeeId = employeeId;
        this.name = name;
        this.leaveBalance = leaveBalance;// initially 20
        this.yearlyAvailableLeave = 0;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void addYearlyRequestedLeave(int leaveBalance) {
        this.yearlyAvailableLeave += leaveBalance;
    }

    public String getName() {
        return name;
    }

    public int getLeaveBalance() {
        return leaveBalance;
    }

    public int getYearlyAvailableLeave() {
        return yearlyAvailableLeave;
    }

    public void setLeaveBalance(int leaveBalance) {
        this.leaveBalance = leaveBalance;
    }
    public abstract int calculateMaxLeave();

}
