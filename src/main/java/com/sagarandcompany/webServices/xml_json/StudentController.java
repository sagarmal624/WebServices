package com.sagarandcompany.webServices.xml_json;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @RequestMapping(value = "/get/{id}", produces = "application/xml", method = RequestMethod.GET)
    public Student getEmployee(@PathVariable("id") Long id) {
        Student student = new Student();
        student.setId(id);
        student.setName("Sagar" + id);
        student.setAge(34);
        return student;
    }

    @RequestMapping(value = "/save", consumes = "application/xml", produces = "application/xml", method = RequestMethod.POST)
    public Student saveEmployee(@RequestBody Student student) {
        return student;
    }

    @RequestMapping(value = "/update", consumes = "application/xml", produces = "application/xml", method = RequestMethod.PUT)
    public Student updateEmployee(@RequestBody Student student) {
        return student;
    }

}
