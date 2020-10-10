package com.devglan.springbootgraphql.repo;

import com.devglan.springbootgraphql.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepo extends JpaRepository<Department, Integer> {
}
