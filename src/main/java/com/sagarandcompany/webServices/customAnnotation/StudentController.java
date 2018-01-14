package com.sagarandcompany.webServices.customAnnotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentRepository studentRepository;

    @ResponseBody
    @RequestMapping(value = "/get/{id}", produces = "application/json", method = RequestMethod.GET)
    public Resource<Student> getStudent(@PathVariable("id") Long id) {
        Resource<Student> resource = new Resource<Student>(studentRepository.findById(id));
        ControllerLinkBuilder linkTo1 = linkTo(methodOn(this.getClass()).getAllStudent());
        ControllerLinkBuilder linkTo2 = linkTo(methodOn(this.getClass()).deleteStudent(id));
        final String uriString = ServletUriComponentsBuilder.fromCurrentRequest().build().toUriString();
        resource.add(new Link(uriString, "self"));

        resource.add(linkTo1.withRel("all_Student"));
        resource.add(linkTo2.withRel("delete"));
        return resource;
    }

    @RequestMapping(value = "/get", produces = "application/json", method = RequestMethod.GET)
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @PostJson(path = "/save")
    public Student saveStudent(@RequestBody Student Student, HttpServletRequest request, @RequestHeader HttpHeaders headers) {
        return studentRepository.save(Student);
    }

    @RequestMapping(value = "/update", consumes = "application/json", produces = "application/json", method = RequestMethod.PUT)
    public Student updateStudent(@RequestBody Student Student) {
        return studentRepository.save(Student);
    }

    @RequestMapping(value = "/delete/{id}", consumes = "application/json", produces = "application/json", method = RequestMethod.DELETE)
    public Map deleteStudent(@PathVariable("id") Long id) {
        studentRepository.delete(id);
        Map map = new HashMap();
        map.put("status", true);
        map.put("message", "Record is sussfullly deleted");
        return map;
    }
}
