package br.com.fiap.cashiq_backend.infrastructure.ports.in.web.dto.response;

import java.util.UUID;

public record UserResponseDto(
        UUID cd_user,
        String user_email
) {
}
