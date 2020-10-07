package gr.dataverse.react.spring.service.impl;

import gr.dataverse.react.spring.entity.Employee;
import gr.dataverse.react.spring.mapper.EmployeeMapper;
import gr.dataverse.react.spring.model.EmployeeModel;
import gr.dataverse.react.spring.model.EmployeeModelResponse;
import gr.dataverse.react.spring.model.EmployeeModelRequest;
import gr.dataverse.react.spring.repository.EmployeeRepository;
import gr.dataverse.react.spring.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getById(int id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void delete(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public EmployeeModelResponse createEmployeeResponse(EmployeeModelRequest employeeModelRequest) {

        Pageable pageable = PageRequest.of(employeeModelRequest.getPageCount() - 1, employeeModelRequest.getPageSize(), Sort.by("id").descending());
//        Specification<Employee> specification;

        List<EmployeeModel> employeeModelList = new ArrayList<>();
        List<Employee> employeeList = employeeRepository.findAllPageable(pageable);

        for (Employee employee : employeeList) {
            employeeModelList.add(EmployeeMapper.toEmployeeModel(employee));
        }


        EmployeeModelResponse employeeModelResponse = new EmployeeModelResponse(
                employeeModelList, employeeModelList.size(), 0, 0,0);

        return employeeModelResponse;
    }
}
