package net.prasenjit.poc.library.core.filter;

import net.prasenjit.poc.library.core.TestContext;
import net.prasenjit.poc.library.core.config.ApiConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = TestContext.class)
class ContextFilterTest {

    @Autowired
    private ApiConfig apiConfig;

    @Test
    void filter() {
        assertEquals("some name", apiConfig.name());
    }
}