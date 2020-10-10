package com.devglan.springbootgraphql.repo;

import com.devglan.springbootgraphql.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
}
