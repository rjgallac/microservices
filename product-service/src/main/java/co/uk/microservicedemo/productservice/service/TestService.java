package co.uk.microservicedemo.productservice.service;

import co.uk.microservicedemo.productservice.model.Product;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@AllArgsConstructor
@Service
@Slf4j
public class TestService implements ITestService {

    RestTemplate restTemplate;
    private WebClient webClient;

    public List<Product> get() {
        ResponseEntity<List<Product>> exchange = restTemplate.exchange("http://inventory-service/api/inventory", HttpMethod.GET, null, new ParameterizedTypeReference<>() {});
        List<Product> products = exchange.getBody();

//        List<Product> products = webClient.get()
//                .uri("http://inventory-service/api/inventory")
//                .retrieve()
//                .bodyToMono(new ParameterizedTypeReference<List<Product>>() {
//                }).block();
        assert products != null;
        log.info("SUCCESS");
        return new ArrayList<>(products);
    }

    public String getTest2(){
        try {
            Random random = new Random();
            int i = random.nextInt(5) +1;
            log.info("in test product service {}", i);
//            String body = restTemplate.getForEntity("http://inventory-service/api/inventory" + i, String.class).getBody();
            String body = webClient.get()
                .uri("http://inventory-service/api/inventory" + i)
                .retrieve()
                .bodyToMono(String.class)
                .block();
            return body;
        } catch (Exception exception) {
            System.out.println("HERE");
            throw exception;
        }
    }
}
