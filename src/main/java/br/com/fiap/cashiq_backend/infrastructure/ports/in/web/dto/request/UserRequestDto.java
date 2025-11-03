package br.com.fiap.cashiq_backend.infrastructure.ports.in.web.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRequestDto(
        @NotBlank(message = "USER_EMAIL_IS_REQUIRED")
        @Email(message = "USER_EMAIL_IS_INVALID")
        String email,

        @NotBlank(message = "USER_PASSWORD_IS_REQUIRED")
        String password,

        @NotBlank(message = "USER_CONFIRM_PASSWORD_IS_REQUIRED")
        String confirmPassword
) {
}
