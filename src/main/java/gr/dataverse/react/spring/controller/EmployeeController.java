package gr.dataverse.react.spring.controller;

import gr.dataverse.react.spring.entity.Employee;
import gr.dataverse.react.spring.model.EmployeeModelRequest;
import gr.dataverse.react.spring.model.EmployeeModelResponse;
import gr.dataverse.react.spring.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @PostMapping("/employee")
    public Employee save(@RequestBody Employee employee) {
        employeeService.save(employee);
        return employee;
    }

    @GetMapping("/employee/{id}")
    public Optional<Employee> get(@PathVariable int id) {
        return employeeService.getById(id);
    }

    @DeleteMapping("/employee/{id}")
    public String delete(@PathVariable int id) {

        employeeService.delete(id);

        return "Employee removed with id "+id;

    }

    @PutMapping("/employee")
    public Employee update(@RequestBody Employee employee) {
        employeeService.save(employee);
        return employee;
    }

    @PostMapping("/ams/fetchData")
    public ResponseEntity<EmployeeModelResponse> postRequestUpdate(@RequestBody EmployeeModelRequest employeeModelRequest) {
//        List<EmployeeModel> employeeModels = employeeService.fetchEmployees();

        EmployeeModelResponse employeeModelResponse = employeeService.createEmployeeResponse(employeeModelRequest);
        return ResponseEntity.ok(employeeModelResponse);
    }

}
