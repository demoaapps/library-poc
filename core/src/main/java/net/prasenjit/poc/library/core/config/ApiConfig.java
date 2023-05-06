package net.prasenjit.poc.library.core.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "lib.api")
public record ApiConfig(String name) {
}
