package co.uk.microservicedemo.productservice.service;

import co.uk.microservicedemo.productservice.model.Product;
import org.springframework.retry.annotation.Retryable;

import java.util.List;

interface ITestService {
    @Retryable
    List<Product> get() throws Exception;
}
