package co.uk.microservicedemo.productservice.repository;

import co.uk.microservicedemo.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
