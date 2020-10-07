package gr.dataverse.react.spring.model;

import java.util.List;

public class EmployeeModelResponse {

    private List<EmployeeModel> employeeModels;

    private int totalEmployees;

    private int currentPage;

    private int recordsTotal;

    private int recordsFiltered;

    public EmployeeModelResponse(List<EmployeeModel> employeeModels, int totalEmployees, int currentPage, int recordsTotal, int recordsFiltered) {
        this.employeeModels = employeeModels;
        this.totalEmployees = totalEmployees;
        this.currentPage = currentPage;
        this.recordsTotal = recordsTotal;
        this.recordsFiltered = recordsFiltered;
    }

    public List<EmployeeModel> getEmployeeModels() {
        return employeeModels;
    }

    public void setEmployeeModels(List<EmployeeModel> employeeModels) {
        this.employeeModels = employeeModels;
    }

    public int getTotalEmployees() {
        return totalEmployees;
    }

    public void setTotalEmployees(int totalEmployees) {
        this.totalEmployees = totalEmployees;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
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
