package com.demo.jal.service;

import com.demo.jal.model.LoggingAccount;
import com.demo.jal.model.Token;
import com.demo.jal.model.record.AuthRequest;
import com.demo.jal.model.record.RegisterRequest;
import com.demo.jal.model.record.TokenResponse;
import com.demo.jal.model.repository.AccountRepository;
import com.demo.jal.model.repository.TokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AccountRepository repository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public TokenResponse register(final RegisterRequest request) {
        final LoggingAccount user = LoggingAccount.builder()
                .name(request.name())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .build();

        final LoggingAccount savedUser = repository.save(user);
        final String jwtToken = jwtService.generateToken(savedUser);

        saveUserToken(savedUser, jwtToken);
        return new TokenResponse(jwtToken);
    }

    public TokenResponse authenticate(final AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.password()
                )
        );
        final LoggingAccount loggingAccount = repository.findByEmail(request.email())
                .orElseThrow();
        final String accessToken = jwtService.generateToken(loggingAccount);
        revokeAllUserTokens(loggingAccount);
        saveUserToken(loggingAccount, accessToken);
        return new TokenResponse(accessToken);
    }

    private void saveUserToken(LoggingAccount loggingAccount, String jwtToken) {
        final Token token = Token.builder()
                .accounts(loggingAccount)
                .token(jwtToken)
                .tokenType(Token.TokenType.BEARER)
                .isExpired(false)
                .isRevoked(false)
                .build();
        tokenRepository.save(token);
    }

    private void revokeAllUserTokens(final LoggingAccount loggingAccount) {
        final List<Token> validUserTokens = tokenRepository
                .findAllValidTokenByUser(loggingAccount.getId());
        if (!validUserTokens.isEmpty()) {
            for (final Token token : validUserTokens) {
                token.setIsExpired(true);
                token.setIsRevoked(true);
            }
            tokenRepository.saveAll(validUserTokens);
        }
    }
}
