package com.raqib.rs_crud.controller;

import com.raqib.rs_crud.exception.EmployeeNotFound;
import com.raqib.rs_crud.model.Employee;
import com.raqib.rs_crud.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    private final EmployeeRepository repository;

    public EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/employees")
    List<Employee> all(){
        return repository.findAll();
    }

    @PostMapping("/employees")
    Employee newEmployee(@RequestBody Employee employee){
        return repository.save(employee);
    }

    @GetMapping("/employees/{id}")
    Employee one(@PathVariable Long id){
        return repository.findById(id).orElseThrow(() -> new EmployeeNotFound(id));
    }

    @PutMapping("/employees/{id}")
    Employee replaceEmployee(@RequestBody Employee newEmployee,@PathVariable Long id){
        return repository.findById(id).map(employee -> {
            employee.setName(newEmployee.getName());
            employee.setRole(newEmployee.getRole());
            return repository.save(employee);
        }).orElseGet(()->{
           newEmployee.setId(id);
           return repository.save(newEmployee);
        });
    }
}
