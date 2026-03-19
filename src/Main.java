import com.organization.leavemanagement.exception.EmployeeNotFoundException;
import com.organization.leavemanagement.exception.InsufficientLeaveBalanceException;
import com.organization.leavemanagement.exception.InvalidLeaveRequestException;
import com.organization.leavemanagement.model.*;
import com.organization.leavemanagement.repository.EmployeeRepository;
import com.organization.leavemanagement.service.LeaveApplication;

import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        EmployeeRepository repo = new EmployeeRepository();
        repo.addEmployee(new ContractEmployee("CE101","contractemp1",10));
        repo.addEmployee(new PermanentEmployee("PE101","permanentemp2",20));
//        repo.addEmployee(new Employee("TS101","ALICE",15));
//        repo.addEmployee(new Employee("Ts102","ARCHANA",20));
        LeaveApplication service = new LeaveApplication(repo);
        Leaverequest leaverequest1 = new Leaverequest("CE101", LeaveType.SICK,
                6,"I am going for tour",LocalDate.now());
        Leaverequest leaverequest2 = new Leaverequest("CE101", LeaveType.EARNED,7
                ,"I am going for tour",LocalDate.now());
        Leaverequest leaverequest3 = new Leaverequest("CE101", LeaveType.CASUAL,2
                ,"I am going for temple",LocalDate.now());
        Leaverequest leaverequest4 = new Leaverequest("CE101", LeaveType.EARNED,6
                ,"I am going for temple",LocalDate.now());
        Leaverequest leaverequest5 = new Leaverequest("CE101", LeaveType.EARNED,6
                ,"I am going for temple",LocalDate.now());

        try{
            service.applyLeave(leaverequest3);
            service.applyLeave(leaverequest4);
            service.applyLeave(leaverequest5);



        }
        catch (InvalidLeaveRequestException| EmployeeNotFoundException| InsufficientLeaveBalanceException e){
            System.out.print("error" + e.getMessage());
        }

    }
}