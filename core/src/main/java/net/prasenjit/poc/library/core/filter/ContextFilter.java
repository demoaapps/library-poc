package net.prasenjit.poc.library.core.filter;

import net.prasenjit.poc.library.core.rest.ApiContext;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;
import reactor.util.context.Context;

import java.util.UUID;

@Component
public class ContextFilter implements WebFilter {
    @Override
    @NonNull
    public Mono<Void> filter(@NonNull ServerWebExchange exchange, @NonNull WebFilterChain chain) {
        ApiContext apiContext = new ApiContext();
        apiContext.setId(UUID.randomUUID().toString());
        return chain.filter(exchange).contextWrite(Context.of("apiContext", apiContext));
    }
}
