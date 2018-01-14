package com.sagarandcompany.webServices.customAnnotation;

import com.sagarandcompany.webServices.json.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    public Student findById(Long id);
}
