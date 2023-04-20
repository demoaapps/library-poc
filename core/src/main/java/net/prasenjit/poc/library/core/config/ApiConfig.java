package net.prasenjit.poc.library.core.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "lib.api")
public class ApiConfig {
    private String name;
}
