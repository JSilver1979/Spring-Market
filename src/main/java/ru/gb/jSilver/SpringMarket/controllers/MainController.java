package ru.gb.jSilver.SpringMarket.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.gb.jSilver.SpringMarket.dto.Student;
import ru.gb.jSilver.SpringMarket.services.ProductService;
import ru.gb.jSilver.SpringMarket.services.StudentService;

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
        return "index.html";
    }

    @GetMapping("/students")
    public String getStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students.html";
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
