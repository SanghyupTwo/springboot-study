package me.leesanghyup.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.leesanghyup.springbootdeveloper.domain.RefreshToken;
import me.leesanghyup.springbootdeveloper.repository.RefreshTokenRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RefreshTokenService {
    private final RefreshTokenRepository refreshTokenRepository;

    public RefreshToken findByRefreshToken(String refreshToken) {
        return refreshTokenRepository.findByRefreshToken(refreshToken)
                .orElseThrow(() -> new IllegalArgumentException("Unexpected token"));
    }
}
