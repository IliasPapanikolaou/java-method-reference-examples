package org.example;

public class EmployeeMapper {

    public static EmployeeDAO convert(Employee employee) {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        employeeDAO.setId(employee.getId());
        employeeDAO.setName(employee.getName());
        employeeDAO.setSalary(employee.getSalary());
        return employeeDAO;
    }

    public EmployeeDAO convertNonStatic(Employee employee) {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        employeeDAO.setId(employee.getId());
        employeeDAO.setName(employee.getName());
        employeeDAO.setSalary(employee.getSalary());
        return employeeDAO;
    }
}
