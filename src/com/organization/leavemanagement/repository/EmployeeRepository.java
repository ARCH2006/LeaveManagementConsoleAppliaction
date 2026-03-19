package com.organization.leavemanagement.repository;

import com.organization.leavemanagement.model.Employee;

import java.util.HashMap;

public class EmployeeRepository {
    private HashMap<String, Employee> employeeDB = new HashMap<>();
    public void addEmployee(Employee e){
        employeeDB.put(e.getEmployeeId(),e);
    }
    public Employee fetchEmployeeById(String id){
       return employeeDB.get(id);
    }
    public boolean exists(String id){
        return employeeDB.containsKey(id);
    }
}
