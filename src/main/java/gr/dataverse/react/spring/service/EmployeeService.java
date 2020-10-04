package gr.dataverse.react.spring.service;

import gr.dataverse.react.spring.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<Employee> findAll();

    Optional<Employee> getById(int id);

    void save(Employee employee);

    void delete(int id);
}