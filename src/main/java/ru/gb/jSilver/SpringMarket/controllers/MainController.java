package ru.gb.jSilver.SpringMarket.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.jSilver.SpringMarket.dto.Student;
import ru.gb.jSilver.SpringMarket.services.ProductService;
import ru.gb.jSilver.SpringMarket.services.StudentService;

import java.util.List;

//@Controller
@Controller
@RequiredArgsConstructor
public class MainController {

    private final StudentService studentService;
    private final ProductService productService;

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello Spring Market";
    }

    @GetMapping("/calc")
    @ResponseBody
    public int calc(@RequestParam(name = "first") int a,
                    @RequestParam(required = false, defaultValue = "0", name = "second") int b) {
        return a + b;
    }

    @GetMapping("/products/{anyName}/info")
    @ResponseBody
    public String products(@PathVariable(name = "anyName") String id) {
        return "Product with id:" + id;
    }

    @GetMapping("/page")
    public String page(Model model, @RequestParam Integer id) {
        model.addAttribute("student", studentService.getStudentByID(id));
        return "index";
    }

    @GetMapping("/students")
    public String getStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }

    @GetMapping("/students/add")
    @ResponseBody
    public void addStudent(Integer id, String name) {
        studentService.addNewStudent(id, name);
    }

    @GetMapping("/show_page")
    public String form() {
        return "add_student";
    }

    @GetMapping("/json")
    @ResponseBody
    public List<Student> jsonResponse() {
        return studentService.getAllStudents();
    }

    @PostMapping("/students/add")
    @ResponseBody
    public void addStudentPost(@RequestBody Student student) {
        studentService.addStudent(student);
    }

    @GetMapping("/products")
    public String getProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products.html";
    }
    @GetMapping("/info")
    public String info(Model model, @RequestParam Integer id) {
        model.addAttribute("product", productService.getProductByID(id));
        return "info.html";
    }
}
