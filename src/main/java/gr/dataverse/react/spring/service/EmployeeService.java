package gr.dataverse.react.spring.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import gr.dataverse.react.spring.entity.Employee;
import gr.dataverse.react.spring.model.EmployeeModel;
import gr.dataverse.react.spring.json.TableFetchRequest;
import gr.dataverse.react.spring.json.TableFetchResponse;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<Employee> findAll();

    Optional<Employee> getById(int id);

    void save(Employee employee);

    void delete(int id);

    TableFetchResponse<EmployeeModel> fetchEmployeeData(TableFetchRequest tableFetchRequest);

}