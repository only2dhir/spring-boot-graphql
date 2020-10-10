package com.devglan.springbootgraphql.controller;

import com.devglan.springbootgraphql.model.Department;
import com.devglan.springbootgraphql.service.DepartmentService;
import com.devglan.springbootgraphql.service.GraphQLProvider;
import graphql.ExecutionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private GraphQLProvider graphQLProvider;

    @PostMapping("/graphql/dept")
    public ResponseEntity<Object> listDepartments(@RequestBody String query){
        ExecutionResult execute = graphQLProvider.graphQL().execute(query);

        return new ResponseEntity<>(execute, HttpStatus.OK);
    }

    @GetMapping("/dept")
    public ResponseEntity<List<Department>> listDepartments(){
        return new ResponseEntity<>(departmentService.allDepartments(), HttpStatus.OK);
    }
}
