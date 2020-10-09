package gr.dataverse.react.spring.model;

import java.util.List;

public class TableEmployeeFetchResponse {

    private List<EmployeeModel> employeeModels;

    private int pageCount;

    private int recordsTotal;

    private int recordsFiltered;

    public TableEmployeeFetchResponse(List<EmployeeModel> employeeModels, int pageCount, int recordsTotal, int recordsFiltered) {
        this.employeeModels = employeeModels;
        this.pageCount = pageCount;
        this.recordsTotal = recordsTotal;
        this.recordsFiltered = recordsFiltered;
    }

    public List<EmployeeModel> getEmployeeModels() {
        return employeeModels;
    }

    public void setEmployeeModels(List<EmployeeModel> employeeModels) {
        this.employeeModels = employeeModels;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(int recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public int getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(int recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }
}
