package net.prasenjit.poc.library.example;

import lombok.extern.log4j.Log4j2;
import net.prasenjit.poc.library.core.MyConstraint;
import net.prasenjit.poc.library.core.rest.ApiContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Log4j2
@RestController
@SpringBootApplication
public class ExampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExampleApplication.class, args);
    }

    @GetMapping("test1")
    public Mono<String> home() {

        return Mono.deferContextual(contextView -> {
            ApiContext apiContext = contextView.getOrDefault("apiContext", null);
            if (apiContext != null) {
                return Mono.just(apiContext);
            } else {
                return Mono.empty();
            }
        }).map(ApiContext::toString);
    }

    @PostMapping("test")
    public Person test(@RequestBody @Validated Person person) {
        return person;
    }

    @MyConstraint
    private record Person(String name) {
    }
}
