package com.demo.jal.controller;

import com.demo.jal.model.record.AuthRequest;
import com.demo.jal.model.record.RegisterRequest;
import com.demo.jal.model.record.TokenResponse;
import com.demo.jal.service.AuthService;
import com.demo.jal.utils.exception.ErrorResponseDTO;
import com.demo.jal.utils.exception.InvalidInputException;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Tag(name = "Authentication", description = "Register an user and create tokens with the credentials")
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);


    private final AuthService service;

    @PostMapping("/register")
    public ResponseEntity<TokenResponse> register(@RequestBody RegisterRequest request) {

        try {
            final TokenResponse response = service.register(request);
            return ResponseEntity.ok(response);
        } catch (InvalidInputException e) {
            throw new InvalidInputException();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody AuthRequest request) {

        try {
            final TokenResponse response = service.authenticate(request);
            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            ErrorResponseDTO errorDetails = new ErrorResponseDTO(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                    "An unexpected error occurred while fetching the product.",
                    "httpRequest.getRequestURI()"
            );
            return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}