package br.com.fiap.cashiq_backend.infrastructure.ports.in.web.dto.response;

import java.math.BigDecimal;
import java.util.UUID;

public record ExpenseResponseDto(UUID cd_expense, String ds_expense, BigDecimal vl_expense) {
}
