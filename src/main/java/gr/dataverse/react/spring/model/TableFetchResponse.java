package gr.dataverse.react.spring.model;

import java.util.List;

public class TableFetchResponse<T> {

    private List<T> entityModels;

    private int pageCount;

    private int recordsTotal;

    private int recordsFiltered;

    public TableFetchResponse(List<T> entityModels, int pageCount, int recordsTotal, int recordsFiltered) {
        this.entityModels = entityModels;
        this.pageCount = pageCount;
        this.recordsTotal = recordsTotal;
        this.recordsFiltered = recordsFiltered;
    }

    public List<T> getEntityModels() {
        return entityModels;
    }

    public void setEntityModels(List<T> entityModels) {
        this.entityModels = entityModels;
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
