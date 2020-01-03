package com.pvc.core;

import com.pvc.core.beans.Employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsExamples {

    public static void main(String[] args) {
        List<Employee>  employees = getEmployees();

        // Collecting field values
        List<Integer> empIds = employees.stream().map(Employee::getEmpId).collect(Collectors.toList());
        System.out.println(empIds);
        //[9, 1]

        // Identifying Maximum EmpDoj(Date) Employee
        Employee employee = employees.stream().max(Comparator.comparing(Employee::getDoj)).get();
        System.out.println(employee);
        //Employee{empId=1, empName='gggg', doj=Thu Jan 01 07:40:54 IST 1970}

        // Identifying minimum EmpId Employee
        employee = employees.stream().min(Comparator.comparing(Employee::getEmpId)).get();
        System.out.println(employee);
        //Employee{empId=1, empName='gggg', doj=Thu Jan 01 07:40:54 IST 1970}

        // All employee names in capital letters
        employees =  employees.stream().map(emp -> {
            emp.setEmpName(emp.getEmpName().toUpperCase());
           return  emp;
        }).collect(Collectors.toList());
        System.out.println(employees);
        //[Employee{empId=9, empName='VENKAT', doj=Thu Jan 01 05:32:03 IST 1970}, Employee{empId=1, empName='GGGG', doj=Thu Jan 01 07:40:54 IST 1970}]

        // Collect field names to capital
        List<String> capitalNames = employees.stream().map(Employee::getEmpName).map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(capitalNames); //[VENKAT, GGGG]

        //Findfirst
        employee = employees.stream().findFirst().get();
        System.out.println(employee);
        //Employee{empId=9, empName='VENKAT', doj=Thu Jan 01 05:32:03 IST 1970}

        //Filter emplId > 1
        employees = employees.stream().filter(emp ->  emp.getEmpId() > 1).collect(Collectors.toList());
        System.out.println(employees);
       // [Employee{empId=9, empName='VENKAT', doj=Thu Jan 01 05:32:03 IST 1970}]

        //Filter emplId > 1 and limit  to 1
        employees = employees.stream().filter(emp ->  emp.getEmpId() > 1).limit(1).collect(Collectors.toList());
        System.out.println(employees);
        // [Employee{empId=9, empName='VENKAT', doj=Thu Jan 01 05:32:03 IST 1970}]

    }

    private static List<Employee> getEmployees() {
        List<Employee> employees = new ArrayList<>();
        Employee emp1 = new Employee(9,"Venkat" , new Date(123456));
        Employee emp2 = new Employee(1,"gggg" , new Date(7854869));
        employees.add(emp1);
        employees.add(emp2);
        return employees;
    }
}
