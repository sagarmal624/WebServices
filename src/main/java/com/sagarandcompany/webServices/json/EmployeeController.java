package com.sagarandcompany.webServices.json;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;

    @ResponseBody
    @RequestMapping(value = "/get/{id}", produces = "application/json", method = RequestMethod.GET)
    public Resource<Employee> getEmployee(@PathVariable("id") Long id) {
        Resource<Employee> resource = new Resource<Employee>(employeeRepository.findById(id));
        ControllerLinkBuilder linkTo1 = linkTo(methodOn(this.getClass()).getAllEmployee());
        ControllerLinkBuilder linkTo2 = linkTo(methodOn(this.getClass()).deleteEmployee(id));
        final String uriString = ServletUriComponentsBuilder.fromCurrentRequest().build().toUriString();
        resource.add(new Link(uriString, "self"));

        resource.add(linkTo1.withRel("all_employee"));
        resource.add(linkTo2.withRel("delete"));
        return resource;
    }

    @ResponseBody
    @RequestMapping(value = "/get", produces = "application/json", method = RequestMethod.GET)
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @ResponseBody
    @RequestMapping(value = "/save", consumes = "application/json", produces = "application/json", method = RequestMethod.POST)
    public Employee saveEmployee(@RequestBody Employee employee, HttpServletRequest request, @RequestHeader HttpHeaders headers) {
        return employeeRepository.save(employee);
    }

    @ResponseBody
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
