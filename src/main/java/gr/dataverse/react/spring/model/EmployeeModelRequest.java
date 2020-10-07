package gr.dataverse.react.spring.model;

public class EmployeeModelRequest {

    int pageSize;
    int pageCount;

    public EmployeeModelRequest(int pageSize, int pageCount) {
        this.pageSize = pageSize;
        this.pageCount = pageCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
}
