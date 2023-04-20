package net.prasenjit.poc.library.core.exception;

import java.util.Map;

public interface ExResolver<E extends Throwable> {
    Map<String, Object> resolve(E exception);
}
