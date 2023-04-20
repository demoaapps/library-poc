package net.prasenjit.poc.library.core.appconfig;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;

@AutoConfiguration
@ComponentScan(basePackages = "net.prasenjit.poc.library.core")
@ConfigurationPropertiesScan(basePackages = "net.prasenjit.poc.library.core.config")
public class CoreImport {
}
