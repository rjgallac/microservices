package co.uk.microservicedemo.productservice.service;

import co.uk.microservicedemo.productservice.dto.ProductRequest;
import co.uk.microservicedemo.productservice.dto.ProductResponse;
import co.uk.microservicedemo.productservice.model.Product;
import co.uk.microservicedemo.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void add(ProductRequest productRequest){
        Product product = Product.builder().name(productRequest.getName()).build();
        productRepository.save(product);
    }

    public List<ProductResponse> getAll() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(this::mapToResponse).toList();
    }

    private ProductResponse mapToResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .build();
    }
}
