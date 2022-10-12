package ru.gb.jSilver.SpringMarket.repos;

import org.springframework.stereotype.Repository;
import ru.gb.jSilver.SpringMarket.dto.Student;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class StudentRepository {
    private List<Student> studentList;

    @PostConstruct
    public void init(){
        studentList = new ArrayList<>(Arrays.asList(
                new Student(1,"Tom", 100),
                new Student(2,"Bob", 100),
                new Student(3,"Jack", 100),
                new Student(4,"Jim", 100),
                new Student(5,"Sue", 100),
                new Student(6,"Andy", 100),
                new Student(7,"Clark", 100)
        ));
    }

    public Student findByID(Integer id) {
        return studentList.stream().filter(student -> student.getId().equals(id)).findFirst()
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public List<Student> getAllStudents() {
        return studentList;
    }

    public void addStudent2(Integer id, String name, Integer score) {
        studentList.add(new Student(id, name, score));
    }

    public void addStudent2(Student student) {
        studentList.add(student);
    }
}
