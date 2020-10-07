package gr.dataverse.react.spring.mapper;

import gr.dataverse.react.spring.model.EmployeeModel;
import gr.dataverse.react.spring.entity.Employee;

public class EmployeeMapper {

    public static EmployeeModel toEmployeeModel(Employee employee){

        EmployeeModel employeeModel = new EmployeeModel(
                String.valueOf(employee.getId()),
                employee.getName(),
                employee.getDepartment(),
                String.valueOf(employee.getDob()),
                employee.getGender());

        return employeeModel;

    }
}
