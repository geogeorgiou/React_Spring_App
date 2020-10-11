package gr.dataverse.react.spring.mapper;

import gr.dataverse.react.spring.entity.Employee;
import gr.dataverse.react.spring.model.EmployeeModel;

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

//    public static Map<String, String> toJAXEmployee(List<Employee> employeeList) throws JsonProcessingException {
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.enable(SerializationFeature.INDENT_OUTPUT);
//
//        //works but does a conversion of values for date must be set for application properties
//
//        Map<String, String> empListMap = new HashMap<>();
//
//        Map<String, String> tableFetchResponse = new HashMap<>();
//        tableFetchResponse.put("entityModels",mapper.writeValueAsString(employeeList));
//        tableFetchResponse.put("pageCount", String.valueOf(pageCount));
//        tableFetchResponse.put("recordsTotal", String.valueOf(mapper.writeValueAsString(recordsTotal)));
//        tableFetchResponse.put("recordsFiltered", String.valueOf(mapper.writeValueAsString(0)));
//
//        return empListMap;
//    }

}
