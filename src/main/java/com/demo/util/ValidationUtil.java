package com.demo.util;


import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.Map;

public class ValidationUtil {
    @Nullable
    public static Map<String, Object> getMessageModelFromBindingResult(@NotNull BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, Object> message = new HashMap<>();
            bindingResult.getFieldErrors().forEach(fieldError ->
                message.put(fieldError.getObjectName() + "." +fieldError.getField(), fieldError.getDefaultMessage())
            );
            return message;
        }
        return null;
    }
}
