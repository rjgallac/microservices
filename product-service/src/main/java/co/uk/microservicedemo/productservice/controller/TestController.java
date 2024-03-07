package co.uk.microservicedemo.productservice.controller;

import co.uk.microservicedemo.productservice.dto.ProductRequest;
import co.uk.microservicedemo.productservice.model.Product;
import co.uk.microservicedemo.productservice.service.TestService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/test")
public class TestController {

    private TestService testService;

    @GetMapping
    public ResponseEntity<List<Product>> get(){
        return ResponseEntity.ok(testService.get());
    }


    @GetMapping("test2")
    public ResponseEntity<String> test2(){
        return new ResponseEntity<>(testService.getTest2(), HttpStatusCode.valueOf(200));

    }


}
