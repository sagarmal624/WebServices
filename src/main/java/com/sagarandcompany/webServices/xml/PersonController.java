package com.sagarandcompany.webServices.xml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    PersonRepository personRepository;

    @RequestMapping(value = "/get/{id}", produces = "application/xml", method = RequestMethod.GET)
    public Person getEmployee(@PathVariable("id") Long id) {
        return personRepository.findById(id);
    }

    @RequestMapping(value = "/get", produces = "application/xml", method = RequestMethod.GET)
    public List<Person> getAllEmployee() {
        return personRepository.findAll();
    }

    @RequestMapping(value = "/save", consumes = "application/json", produces = "application/xml", method = RequestMethod.POST)
    public Person saveEmployee(@RequestBody Person person) {
        return personRepository.save(person);
    }

    @RequestMapping(value = "/update", consumes = "application/json", produces = "application/xml", method = RequestMethod.PUT)
    public Person updateEmployee(@RequestBody Person person) {
        return personRepository.save(person);
    }

    @RequestMapping(value = "/delete/{id}", consumes = "application/json", produces = "application/xml", method = RequestMethod.DELETE)
    public Map deleteEmployee(@PathVariable("id") Long id) {
        personRepository.delete(id);
        Map map = new HashMap();
        map.put("status", true);
        map.put("message", "Record is sussfullly deleted");
        return map;
    }
}
