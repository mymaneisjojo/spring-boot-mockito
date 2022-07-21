package com.example.repository;

import com.example.entity.Employee;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
class EmployeeRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void whenFindByName_thenReturnEmployee(){
        String name = "hue";
        Employee employee = new Employee();
        employee.setName(name);
        entityManager.persist(employee);
        entityManager.flush();

        // when
        Employee found = employeeRepository.findByName(employee.getName());

        // then
        Assert.assertNotNull(found);
        Assert.assertEquals(found.getName(),name);
    }
}