package br.com.fiap.cashiq_backend.infrastructure.ports.in.web.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ExpenseRequestDto(
        @NotBlank(message = "EXPENSE_IS_REQUIRED")
        String ds_expense,

        @NotNull(message = "EXPENSE_VALUE_IS_REQUIRED")
        @Positive(message = "EXPENSE_VALUE_MUST_BE_POSITIVE")
        BigDecimal vl_expense,

        @NotBlank(message = "USER_ID_IS_REQUIRED")
        String cd_user
) {
}
