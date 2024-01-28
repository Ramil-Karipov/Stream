package com.stream.Stream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService; }

    @GetMapping("/all")
    public Collection<Employee> all() {
        return employeeService.getAll(); }

    @GetMapping("/add")
    public Employee add(String fullName, int department, Integer salary) {
        return employeeService.add(new Employee(fullName, department, salary));
    }
    @GetMapping("/remove")
    public Employee remove(String fullName) { return  employeeService.remove(fullName); }
    @GetMapping("/find")
    public Employee find(String fullName) { return employeeService.find(fullName); }
}

