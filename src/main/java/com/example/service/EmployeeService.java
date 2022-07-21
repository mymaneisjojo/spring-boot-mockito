package com.example.service;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee findByName(String name){
        return employeeRepository.findByName(name);
    }

    public List<Employee> all(){
        return employeeRepository.findAll();
    }

}
