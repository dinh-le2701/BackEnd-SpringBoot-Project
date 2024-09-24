package com.spring.crud_app.service.serviceimpl;

import com.spring.crud_app.model.Employee;
import com.spring.crud_app.repository.EmployeeRepository;
import com.spring.crud_app.service.EmployeeService;
import com.spring.crud_app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public Employee saveEmployee(Employee employee
                                 //MultipartFile file
    ) {
//        try {
//            Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
//        } catch (Exception e) {
//            if (e instanceof FileAlreadyExistsException) {
//                throw new RuntimeException("A file of that name already exists.");
//            }
//
//            throw new RuntimeException(e.getMessage());
//        }
        return employeeRepository.save(employee);
    }

    @Override
    public Iterable<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Employee updateEmployee( Long id, Employee updateEmployee) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found employee has id: " + id));

        employee.setFirstname(updateEmployee.getFirstname());
        employee.setLastname(updateEmployee.getLastname());
        employee.setEmail(updateEmployee.getEmail());

        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
