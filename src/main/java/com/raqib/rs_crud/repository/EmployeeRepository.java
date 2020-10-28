package com.raqib.rs_crud.repository;

import com.raqib.rs_crud.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
