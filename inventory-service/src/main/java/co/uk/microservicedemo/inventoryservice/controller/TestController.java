package co.uk.microservicedemo.inventoryservice.controller;

import co.uk.microservicedemo.inventoryservice.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/api/inventory")
@Slf4j
public class TestController {
    @GetMapping
    public ResponseEntity<List<Product>> get() throws InterruptedException {
        Random random = new Random();
        int i = random.nextInt(3);
        Thread.sleep(i * 1000);
        log.info("called test with {}", i);
        return ResponseEntity.ok(List.of(new Product()));

    }

    @GetMapping("test2")
    public ResponseEntity<String> test2(){
        log.info("called test 2 with {}");
        return new ResponseEntity<>(HttpStatusCode.valueOf(400));
    }

    @GetMapping("test3")
    public ResponseEntity<String> test3(){
        log.info("called test 3 with {}");
        return new ResponseEntity<>("ok", HttpStatusCode.valueOf(200));
    }
    @GetMapping("test4")
    public ResponseEntity<String> test4() throws InterruptedException {
        log.info("called test 4 with {}");

        Random random = new Random();
        int i = random.nextInt(3);
        Thread.sleep(i * 1000);
        return new ResponseEntity<>("hi from 2", HttpStatusCode.valueOf(200));
    }
    @GetMapping("test5")
    public ResponseEntity<String> test5()  {
        log.info("called test 5 with {}");
        int test = 1/0;
        return new ResponseEntity<>("hi from 2", HttpStatusCode.valueOf(200));
    }

}
