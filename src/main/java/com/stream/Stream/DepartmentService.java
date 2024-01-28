package com.stream.Stream;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    public final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Employee getEmployeeWithMaxSalary(int departmentId) {
        return employeeService.getAll().stream()
                .filter(e -> e.getDepartment() == departmentId)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElse(null);
    }

    public Employee getEmployeeWithMinSalary(int departmentId) {
        return employeeService.getAll().stream()
                .filter(e -> e.getDepartment() == departmentId)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElse(null);
    }
    public List<Employee> getEmployeesByDepartment(int departmentId){
        return employeeService.getAll().stream()
                .filter(e -> e.getDepartment() == departmentId)
                .collect(Collectors.toList());
    }
    public Map<Integer, List<Employee>> getEmployeesGroped() {
        return employeeService.getAll().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
