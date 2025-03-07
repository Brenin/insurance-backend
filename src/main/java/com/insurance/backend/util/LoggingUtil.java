package com.insurance.backend.util;

import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class LoggingUtil {

    private LoggingUtil() {}

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingUtil.class);

    public static void logInfo(@NonNull String message) {
        LOGGER.info(message);
    }

    public static void logInfo(@NonNull String message, Object arg) {
        LOGGER.info(message, arg);
    }
}
