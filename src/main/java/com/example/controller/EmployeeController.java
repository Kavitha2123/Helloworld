package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Employee;
import com.example.service.EmployeeService;

@RestController
@RequestMapping("/kav")
public class EmployeeController {
    @Autowired(required = true)
    EmployeeService employeeService;

    @GetMapping("/get")
    //@Scheduled(fixedRate = 5000)
    @Scheduled(cron = "0 * * * * *")
    //@Scheduled(cron = "0 0 12 * * *")
    //@Scheduled(cron = "0 0 * * * *") // This expression executes the task at the top of every hour.
    //@Scheduled(cron = "0 0 0 1 * *")  // This expression executes the task at midnight on the first day of every month.
    //@Scheduled(cron = "0 0/15 * * * ?")//This expression executes the task every 15 minutes, starting from the top of the hour.
    public ResponseEntity<?> getAllEmployees() {
    	List<Employee> emp=employeeService.getAllEmployees();
    	System.out.println(emp);
		return new ResponseEntity(emp,HttpStatus.OK);	
    }

    @PostMapping("/create")
    public ResponseEntity<?> saveEmployee(@RequestBody Employee employee) {
    	System.out.println(employee);
        return new ResponseEntity(employeeService.saveEmployee(employee), HttpStatus.OK);
    }
}
