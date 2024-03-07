package co.uk.microservicedemo.productservice.controller;

import co.uk.microservicedemo.productservice.dto.ProductRequest;
import co.uk.microservicedemo.productservice.dto.ProductResponse;
import co.uk.microservicedemo.productservice.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("/api/product")
@RestController
public class ProductController {

    private final ProductService productService;
    @PostMapping
    public void add(@RequestBody ProductRequest productRequest){
        productService.add(productRequest);

    }

    @GetMapping
    public List<ProductResponse> get(){
        return productService.getAll();
    }

}
