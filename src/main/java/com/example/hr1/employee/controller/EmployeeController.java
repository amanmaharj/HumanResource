package com.example.hr1.employee.controller;

import com.example.hr1.employee.domain.Employee;
import com.example.hr1.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
   public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
   }
//   @GetMapping("/hello")
//   public String showContent(){
//       return "hello world";
//   }
   @GetMapping
    public List<Employee> showEmployee(){
       return employeeService.showAll();
    }
   @PostMapping
    public ResponseEntity<Employee> insertEmployee(@RequestBody Employee employee){
//       employeeService.insertEmp(employee);

       return new ResponseEntity(employeeService.insertEmp(employee), HttpStatus.OK);
   }

}
