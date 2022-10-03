package ru.gb.jSilver.SpringMarket.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.jSilver.SpringMarket.dto.Student;
import ru.gb.jSilver.SpringMarket.repos.StudentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository repo;

    public Student getStudentByID (Integer id) {
        return repo.findByID(id);
    }

    public List<Student> getAllStudents() {
        return repo.getAllStudents();
    }
}
