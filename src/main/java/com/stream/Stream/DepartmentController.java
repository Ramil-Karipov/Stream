package com.stream.Stream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequestMapping
@RestController
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee getMax(@RequestParam("dep") int departmentId) {
        return departmentService.getEmployeeWithMaxSalary(departmentId);
    }

    @GetMapping("/mix-salary")
    public Employee getMin(@RequestParam("dep") int departmentId) {
        return departmentService.getEmployeeWithMinSalary(departmentId);

    }

    @GetMapping (value = "/all", params = "dep")
    public List<Employee> getEmployees(@RequestParam("dep")int departmentId){
        return departmentService.getEmployeesByDepartment(departmentId);

    }
    @GetMapping ("/all")
    Map<Integer, List<Employee>> getEmployees() {
        return departmentService.getEmployeesGroped();
    }

}
