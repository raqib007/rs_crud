package com.raqib.rs_crud.exception;

public class EmployeeNotFound extends RuntimeException {
    public EmployeeNotFound(Long id){
        super("Could Not Found Employee "+id);
    }
}
