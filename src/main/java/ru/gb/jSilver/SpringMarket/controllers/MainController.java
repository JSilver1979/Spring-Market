package ru.gb.jSilver.SpringMarket.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.jSilver.SpringMarket.dto.Product;
import ru.gb.jSilver.SpringMarket.dto.Student;
import ru.gb.jSilver.SpringMarket.services.ProductService;
import ru.gb.jSilver.SpringMarket.services.StudentService;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class MainController {

    private final StudentService studentService;
    private final ProductService productService;

    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("students/change_score")
    public void changeScore(@RequestParam Integer studentId, @RequestParam Integer delta) {
        studentService.changeScore(studentId, delta);
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/change_price")
    public void changePrice(@RequestParam Integer productId,@RequestParam Double price) {
        productService.changePrice(productId, price);
    }

    @GetMapping("/products/delete_product")
    public void deleteProduct(@RequestParam Integer productId) {
        productService.deleteProduct(productId);
    }
}
