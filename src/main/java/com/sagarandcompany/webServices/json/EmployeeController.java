package com.sagarandcompany.webServices.json;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @RequestMapping(value = "/get/{id}", produces = "application/json", method = RequestMethod.GET)
    public Employee getEmployee(@PathVariable("id") Long id) {
        Employee employee = new Employee();
        employee.setId(id);
        employee.setName("Sagar");
        employee.setAge(27);
        employee.setSalary(1000);
        System.out.println(employee.toString());
        return employee;
    }

    @RequestMapping(value = "/form/save/", method = RequestMethod.POST)
    public Employee saveEmployeeForm(@ModelAttribute Employee employee) {
        System.out.println(employee.toString());
        return employee;
    }

    @RequestMapping(value = "/save", consumes = "application/json", produces = "application/json", method = RequestMethod.POST)
    public Employee saveEmployee(@RequestBody Employee employee) {
        System.out.println(employee.toString());
        return employee;
    }

    @RequestMapping(value = "/update", consumes = "application/json", produces = "application/json", method = RequestMethod.PUT)
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employee;
    }

    @RequestMapping(value = "/delete/{id}", consumes = "application/json", produces = "application/json", method = RequestMethod.DELETE)
    public Map deleteEmployee(@PathVariable("id") Long id) {
        /// process the record................
        Map map = new HashMap();
        map.put("status", true);
        map.put("message", "Record is sussfullly deleted");
        return map;
    }
}
