package co.uk.microservicedemo.productservice.service;

import co.uk.microservicedemo.productservice.dto.ProductRequest;
import co.uk.microservicedemo.productservice.dto.ProductResponse;
import co.uk.microservicedemo.productservice.model.Product;
import co.uk.microservicedemo.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    private final KafkaTemplate kafkaTemplate;

    public void add(ProductRequest productRequest){
        kafkaTemplate.send("notifyTopic", productRequest.getName());
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

    public void delete(String id) {
        productRepository.deleteById(id);
    }
}
