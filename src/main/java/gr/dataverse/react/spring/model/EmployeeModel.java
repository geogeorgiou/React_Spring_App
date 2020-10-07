package gr.dataverse.react.spring.model;

public class EmployeeModel {

    private String id;
    private String name;
    private String department;
    private String dob;
    private String gender;

    public EmployeeModel(String id, String name, String department, String dob, String gender) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.dob = dob;
        this.gender = gender;
    }

    public EmployeeModel() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
