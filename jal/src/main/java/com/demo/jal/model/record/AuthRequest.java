package com.demo.jal.model.record;

public record AuthRequest(
        String email,
        String password
        ) {
}