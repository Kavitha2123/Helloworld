package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.model.Employee;
import com.example.repository.EmployeeRepository;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

     //@Scheduled(fixedRate = 5000) // Run every 5 seconds
    //@Scheduled(cron = "0 * * * * *") // Run every minute
    public List<Employee> getAllEmployees() {
	   System.out.println("hhhhhhhhhhhhhhhhhhh");
        return employeeRepository.findAll();
    }

    public Employee saveEmployee(Employee employee) {
    	Optional<Employee> Emp=employeeRepository.findByEmpName(employee.getEmpName());
    	if(Emp.isPresent()) {
    		return null;
    	}
    	else {
    		return employeeRepository.save(employee);	
    	}        
    }
}
