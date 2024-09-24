package com.spring.crud_app.service;

import com.spring.crud_app.model.Employee;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Service
public interface EmployeeService {

    Employee saveEmployee(Employee employee);

    Iterable<Employee> getEmployees();

    Optional<Employee> findEmployeeById(Long id);

    Employee updateEmployee(Long id, Employee updateEmployee);

    void deleteEmployee(Long id);


}