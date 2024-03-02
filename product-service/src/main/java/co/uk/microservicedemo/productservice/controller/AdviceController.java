package co.uk.microservicedemo.productservice.controller;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;

@ControllerAdvice
@ResponseBody
public class AdviceController {

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity handleException(HttpClientErrorException e) {
        return new ResponseEntity(HttpStatusCode.valueOf(e.getStatusCode().value()), HttpStatusCode.valueOf(e.getStatusCode().value()));
    }

    @ExceptionHandler(HttpServerErrorException.class)
    public ResponseEntity handleServerException(HttpServerErrorException e) {
        return new ResponseEntity(HttpStatusCode.valueOf(e.getStatusCode().value()), HttpStatusCode.valueOf(e.getStatusCode().value()));
    }

    @ExceptionHandler(ResourceAccessException.class)
    public ResponseEntity handleResourceException(ResourceAccessException e) {
        return new ResponseEntity("RAE", HttpStatusCode.valueOf(500));
    }
}
