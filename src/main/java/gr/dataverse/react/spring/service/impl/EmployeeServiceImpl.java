package gr.dataverse.react.spring.service.impl;

import gr.dataverse.react.spring.entity.Employee;
import gr.dataverse.react.spring.mapper.EmployeeMapper;
import gr.dataverse.react.spring.model.EmployeeModel;
import gr.dataverse.react.spring.json.TableFetchRequest;
import gr.dataverse.react.spring.json.TableFetchResponse;
import gr.dataverse.react.spring.repository.EmployeeRepository;
import gr.dataverse.react.spring.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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
    public TableFetchResponse<EmployeeModel> fetchEmployeeData(TableFetchRequest tableFetchRequest) {

        Pageable pageable = PageRequest.of(tableFetchRequest.getPageIndex(), tableFetchRequest.getPageSize(), Sort.by("id").descending());
//        Specification<Employee> specification; for later use...

        //find all employees
        List<Employee> employeeList = employeeRepository.findAll();

        //find all employees that belong to the page
        List<Employee> employeeListPageable = employeeRepository.findAll(pageable).getContent();

        List<EmployeeModel> employeeModelList = new ArrayList<>();

        //convert pageable employees to model
        for (Employee employee : employeeListPageable) {
            employeeModelList.add(EmployeeMapper.toEmployeeModel(employee));
        }

        //TOTAL RECORDS
        int recordsTotal = employeeList.size();

        //JSON PAGE SIZE
        int pageSize = tableFetchRequest.getPageSize();

        //TOTAL PAGES calculation
        int pageCount = (int) Math.ceil((double) employeeList.size() / (double) pageSize);

        return new TableFetchResponse<>(employeeModelList, pageCount, recordsTotal, 0);
    }
}
