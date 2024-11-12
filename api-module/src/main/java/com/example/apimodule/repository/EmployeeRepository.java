package com.example.apimodule.repository;

import com.example.apimodule.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
List<Employee> findByLastName(String lastName);
List<Employee> findByFirstName(String firstName);
}
