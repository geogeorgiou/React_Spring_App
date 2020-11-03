package gr.dataverse.react.spring.entity;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_emp")
public class Employee {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column
    private int id;
    @Column
    private String name;
    @Column
    private String department;
    @Column
    private String dob;
    @Column
    private String gender;
    @Override
    public String toString() {
        return "Employee [id= " + id + ", name=" + name + ", department=" + department + ", dob=" + dob + ", gender="
                + gender + "]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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