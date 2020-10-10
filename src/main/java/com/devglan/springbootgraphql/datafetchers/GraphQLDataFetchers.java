package com.devglan.springbootgraphql.datafetchers;

import com.devglan.springbootgraphql.model.Department;
import com.devglan.springbootgraphql.model.Employee;
import com.devglan.springbootgraphql.repo.DepartmentRepo;
import com.devglan.springbootgraphql.repo.EmployeeRepo;
import graphql.schema.DataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class GraphQLDataFetchers {

    @Autowired
    private DepartmentRepo departmentRepo;

    @Autowired
    private EmployeeRepo employeeRepo;

    public DataFetcher getDeptByIdDataFetcher() {
        return dataFetchingEnvironment -> {
            int deptId = dataFetchingEnvironment.getArgument("id");
            return departmentRepo.findById(deptId);
        };
    }

    public DataFetcher getAllDepartmentsDataFetcher() {
        return dataFetchingEnvironment -> departmentRepo.findAll();
    }

    public DataFetcher findEmployeesByDept() {
        return dataFetchingEnvironment -> {
            int deptId = dataFetchingEnvironment.getArgument("id");
            Department department = departmentRepo.findById(deptId).get();
            return department.getEmps();
        };
    }

    @PostConstruct
    public void loadDb(){
        Employee employee = employeeRepo.save(new Employee(1, "Dhiraj", 20, 3456));
        Stream.of(
                new Department(1, "Computer Science", "Computer Science department", Stream.of(employee).collect(Collectors.toList())))
                .forEach(department -> departmentRepo.save(department));
    }
}
