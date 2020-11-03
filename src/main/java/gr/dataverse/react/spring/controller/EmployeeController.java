package gr.dataverse.react.spring.controller;

import gr.dataverse.react.spring.entity.Employee;
import gr.dataverse.react.spring.json.TableFetchRequest;
import gr.dataverse.react.spring.json.TableFetchResponse;
import gr.dataverse.react.spring.model.EmployeeModel;
import gr.dataverse.react.spring.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//THIS DOES TAKE INTO ACCOUNT THE CONTEXT ROOT so omit it!

@RestController
@RequestMapping("/api")
//@CrossOrigin(origins="http://localhost:3000")
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

    @PostMapping("/indexPageable")
    public ResponseEntity< TableFetchResponse<EmployeeModel> > postRequestUpdate(@RequestBody TableFetchRequest tableFetchRequest) {

        try
        {
            Thread.sleep(1000);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }

        TableFetchResponse<EmployeeModel> tableEmployeeFetchResponse = employeeService.fetchEmployeeData(tableFetchRequest);
        return ResponseEntity.ok(tableEmployeeFetchResponse);
    }

}
