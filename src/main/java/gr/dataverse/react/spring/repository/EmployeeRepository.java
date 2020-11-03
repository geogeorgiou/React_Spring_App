package gr.dataverse.react.spring.repository;

import gr.dataverse.react.spring.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {

    List<Employee> findAll();
//    List<Employee> getEmployeePageable(Pageable pageable);
//    void save(Employee emp);
    Optional<Employee> findById(int id);
//
//    Employee findById(int id);
    void deleteById(int id);

}
