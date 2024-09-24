package com.spring.crud_app.controller;

import com.spring.crud_app.model.Employee;
import com.spring.crud_app.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private static Logger log = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("")
    public ResponseEntity<Iterable<Employee>> getEmployees(){
        Iterable<Employee> employees = employeeService.getEmployees();
        log.info("Get all completed!");
        return new ResponseEntity<>(employees, HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable("id") Long id){
        Optional<Employee> employee = employeeService.findEmployeeById(id);
        log.info("Get employee by id completed!" + employee);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> saveEmployee(@RequestBody Employee employee){
        Employee saveEmployee = employeeService.saveEmployee(employee);
        log.info("Save employee successfull!");
        return new ResponseEntity<>(saveEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployeeById(@PathVariable(name = "id") Long id,
                                                       @RequestBody Employee updateEmployee){
        Employee employee =  employeeService.updateEmployee(id, updateEmployee);
        log.info(employee + "has updated!");
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
        log.info("Deleted employee has id: " + id);
    }
}