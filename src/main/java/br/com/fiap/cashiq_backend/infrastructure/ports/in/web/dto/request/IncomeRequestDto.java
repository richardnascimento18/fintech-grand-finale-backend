package br.com.fiap.cashiq_backend.infrastructure.ports.in.web.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record IncomeRequestDto(
        @NotBlank(message = "NAME_OF_INCOME_IS_REQUIRED")
        String ds_income,

        @NotNull(message = "INCOME_VALUE_IS_REQUIRED")
        @Positive(message = "INCOME_VALUE_MUST_BE_POSITIVE")
        BigDecimal vl_income,

        @NotBlank(message = "USER_ID_IS_REQUIRED")
        String cd_user
) {
}
