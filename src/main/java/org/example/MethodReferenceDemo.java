package org.example;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class MethodReferenceDemo {

    public static void main(String[] args) {
        EmployeeService service = new EmployeeService();

        // Anonymous approach
        System.out.println("\n-----Anonymous approach-----");
        service.loadEmployeesFromDB()
                .forEach(new Consumer<Employee>() {
                    @Override
                    public void accept(Employee employee) {
                        System.out.println(employee);
                    }
                });

        // Lambda expression approach
        System.out.println("\n-----Lambda expression approach-----");
        service.loadEmployeesFromDB()
                .forEach(employee -> System.out.println(employee));

        // Method Reference approach with predefined class
        System.out.println("\n-----Method Reference approach-----");
        service.loadEmployeesFromDB()
                .forEach(System.out::println);

        // Method Reference with custom type: customPrint STATIC method
        System.out.println("\n-----Method Reference with custom type-----");
        service.loadEmployeesFromDB().forEach(MethodReferenceDemo::customPrint);

        // Convert object to DAO without Method Reference or Lambda expression, using Function (functional interface)
        List<Object> employeeDAOs = service.loadEmployeesFromDB().stream()
                .map(new Function<Employee, Object>() {
                    @Override
                    public EmployeeDAO apply(Employee employee) {
                        EmployeeDAO employeeDAO = new EmployeeDAO();
                        employeeDAO.setId(employee.getId());
                        employeeDAO.setName(employee.getName());
                        employeeDAO.setSalary(employee.getSalary());
                        return employeeDAO;
                    }
                }).toList();
        employeeDAOs.forEach(System.out::println);

        // Static Method Reference which converts Object to DAO
        System.out.println("\n-----Method Reference which converts Object to DAO-----");
        service.loadEmployeesFromDB()
                .stream()
                .map(EmployeeMapper::convert)
                .forEach(System.out::println);

        // Non-static/Instance Method Reference which converts Object to DAO
        EmployeeMapper employeeMapper = new EmployeeMapper();
        service.loadEmployeesFromDB()
                .stream()
                .map(employeeMapper::convertNonStatic)
                .forEach(System.out::println);

        // List of the employee names
        System.out.println("\n-----List of employees-----");
        List<String> employees = service.loadEmployeesFromDB().stream()
                .map(e -> e.getName())
                .toList();
        System.out.println(employees);

        // List of the employee names with method reference
        System.out.println("\n-----List of employees with method reference-----");
        List<String> employeeNames = service.loadEmployeesFromDB().stream()
                .map(Employee::getName)
                .toList();
        System.out.println(employeeNames);

        // Constructor reference: constructor -> new
        // Employee::new;

        // Lambda - EmployeeManager Functional Interface
        System.out.println("\n-----Lambda - EmployeeManager Functional Interface-----");
        EmployeeManager employeeManager = () -> new Employee();
        employeeManager.getEmployee().getEmployeeInfo();

        // Method Reference - EmployeeManager Functional Interface
        System.out.println("\n-----Method Reference - EmployeeManager Functional Interface-----");
        EmployeeManager employeeManager1 = Employee::new;
        employeeManager1.getEmployee().getEmployeeInfo();

        // Return all the Employee ids in a list
//        service.loadEmployeesFromDB().stream()
//                .map(Employee::getId)
//                .map(ArrayList::new)
//                .forEach(System.out::println);
    }

    public static void customPrint(Employee employee) {
        System.out.println("#" + employee.getId() + " : " + employee);
    }
}
