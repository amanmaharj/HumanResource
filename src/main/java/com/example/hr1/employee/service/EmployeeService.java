package com.example.hr1.employee.service;

import com.example.hr1.employee.doa.EmployeeRepository;
import com.example.hr1.employee.domain.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }


    public Employee insertEmp(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> showAll() {
        return employeeRepository.findAll();
    }
}
