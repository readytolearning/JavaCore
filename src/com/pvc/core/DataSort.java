package com.pvc.core;

import com.pvc.core.beans.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class DataSort {

    public static void main(String[] args) {
        List<String> data = Arrays.asList("Hello", "World!", "How", "Are", "You");
        Collections.sort(data);
        System.out.println(data); //[Are, Hello, How, World!, You]

        //Reverse order
        Collections.sort(data, Collections.reverseOrder());
        System.out.println(data);//[You, World!, How, Hello, Are]

        List<Integer> numberData = Arrays.asList(9,4,5,8,1);
        Collections.sort(numberData);
        System.out.println(numberData); //[1, 4, 5, 8, 9]

        List<Employee> employees = getEmployees();
        Collections.sort(employees);
        System.out.println(employees); // using Comparable
        //[Employee{empId=1, empName='gggg', doj=Thu Jan 01 07:40:54 IST 1970}, Employee{empId=9, empName='Venkat', doj=Thu Jan 01 05:32:03 IST 1970}]

        // Integer Sort
        Collections.sort(employees,Comparator.comparing(Employee::getEmpId));
        System.out.println(employees);
        //[Employee{empId=1, empName='gggg', doj=Thu Jan 01 07:40:54 IST 1970}, Employee{empId=9, empName='Venkat', doj=Thu Jan 01 05:32:03 IST 1970}]

        // String Sort
        Collections.sort(employees,Comparator.comparing(Employee::getEmpName));
        System.out.println(employees);
        //[Employee{empId=9, empName='Venkat', doj=Thu Jan 01 05:32:03 IST 1970}, Employee{empId=1, empName='gggg', doj=Thu Jan 01 07:40:54 IST 1970}]

        // String reverse Sort
        Collections.sort(employees,Comparator.comparing(Employee::getEmpName).reversed());
        System.out.println(employees);
        //[Employee{empId=1, empName='gggg', doj=Thu Jan 01 07:40:54 IST 1970}, Employee{empId=9, empName='Venkat', doj=Thu Jan 01 05:32:03 IST 1970}]

        // Date Sort
        Collections.sort(employees,Comparator.comparing(Employee::getDoj));
        System.out.println(employees);
        //[Employee{empId=9, empName='Venkat', doj=Thu Jan 01 05:32:03 IST 1970}, Employee{empId=1, empName='gggg', doj=Thu Jan 01 07:40:54 IST 1970}]

        // Identify Max object
        Employee maxValue = employees.stream().max(Comparator.comparing(v -> v.getEmpId())).get();
        System.out.println(maxValue);
        //Employee{empId=9, empName='Venkat', doj=Thu Jan 01 05:32:03 IST 1970}

        // Sorting employees
        employees = employees.stream().sorted().collect(Collectors.toList());
        System.out.println(employees);

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
