package com.sagarandcompany.webServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;

    @RequestMapping(value = "/get/{id}", produces = "application/json", method = RequestMethod.GET)
    public Employee getEmployee(@PathVariable("id") Long id) {
        return employeeRepository.findById(id);
    }

    @RequestMapping(value = "/get", produces = "application/json", method = RequestMethod.GET)
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @RequestMapping(value = "/save", consumes = "application/json", produces = "application/json", method = RequestMethod.POST)
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @RequestMapping(value = "/update", consumes = "application/json", produces = "application/json", method = RequestMethod.PUT)
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @RequestMapping(value = "/delete/{id}", consumes = "application/json", produces = "application/json", method = RequestMethod.DELETE)
    public Map deleteEmployee(@PathVariable("id") Long id) {
        employeeRepository.delete(id);
        Map map = new HashMap();
        map.put("status", true);
        map.put("message", "Record is sussfullly deleted");
        return map;
    }
}