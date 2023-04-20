package net.prasenjit.poc.library.core.rest;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Data
@Component
@RequestScope
public class ApiContext {
    private String id;
}
