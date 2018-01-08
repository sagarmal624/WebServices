package com.sagarandcompany.webServices.xml;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.*;

@Entity
@XmlRootElement(name = "person")
@XmlAccessorType(XmlAccessType.NONE)
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @XmlElement
    private Long id;
    @XmlElement
    private String name;
    @XmlElement
    private Integer salary;
    @XmlElement
    private Integer age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
