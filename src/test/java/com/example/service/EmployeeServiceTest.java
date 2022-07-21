package com.example.service;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;


class EmployeeServiceTest {

    @Mock
    private EmployeeService employeeService;

    @MockBean
    private EmployeeRepository employeeRepository;

    @Before
    public void setUp(){

        this.employeeService = new EmployeeService(this.employeeRepository);
        System.out.println(this.employeeService);
        Employee employee = new Employee(1, "hue");
        Mockito.when(employeeService.findByName(anyString())).thenReturn(employee);
//        employee.setName("hue");
//        Mockito.when(employeeRepository.findByName(employee.getName())).thenReturn(employee);


    }

    @Test
    public void whenValidName_thenEmployeeShouldBeFound(){
        Employee employee = new Employee(1, "hue");
        String name = "hue";
        this.employeeService = new EmployeeService(this.employeeRepository);
        System.out.println(employeeService);
        Employee found = employeeService.findByName(name);
        Assert.assertEquals(employee,found);
    }

}