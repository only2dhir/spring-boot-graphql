package com.devglan.springbootgraphql.datafetchers;

import com.devglan.springbootgraphql.model.Department;
import com.devglan.springbootgraphql.repo.DepartmentRepo;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AllDeptDataFetchers implements DataFetcher<List<Department>> {

    @Autowired
    private DepartmentRepo deptRepo;

    @Override
    public List<Department> get(DataFetchingEnvironment dataFetchingEnvironment) throws Exception {
        return deptRepo.findAll();
    }
}
