package gr.dataverse.react.spring.repository;

import gr.dataverse.react.spring.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findAll();
//    void save(Employee emp);
    Optional<Employee> findById(int id);
    void deleteById(int id);

}
