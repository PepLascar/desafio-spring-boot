package com.demo.jal.model.record;

public record RegisterRequest(
        String name,
        String email,
        String password
        ) {
}
