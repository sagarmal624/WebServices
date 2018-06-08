package com.sagarandcompany.webServices.xml;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/person")
public class PersonController {

    @RequestMapping(value = "/get/{id}", produces = "application/xml", method = RequestMethod.GET)
    public Person getEmployee(@PathVariable("id") Long id) {
        Person person = new Person();
        person.setId(id);
        person.setName("Sagar" + id);
        person.setAge(34);
        return person;
    }

    @RequestMapping(value = "/save", consumes = "application/json", produces = "application/xml", method = RequestMethod.POST)
    public Person saveEmployee(@RequestBody Person person) {
        return person;
    }

    @RequestMapping(value = "/update", consumes = "application/json", produces = "application/xml", method = RequestMethod.PUT)
    public Person updateEmployee(@RequestBody Person person) {
        return person;
    }

    @RequestMapping(value = "/delete/{id}", consumes = "application/json", produces = "application/xml", method = RequestMethod.DELETE)
    public Map deleteEmployee(@PathVariable("id") Long id) {
        Map map = new HashMap();
        map.put("status", true);
        map.put("message", "Record is sussfullly deleted");
        return map;
    }
}
