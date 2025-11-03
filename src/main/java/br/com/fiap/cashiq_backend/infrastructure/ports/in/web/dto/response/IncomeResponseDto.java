package br.com.fiap.cashiq_backend.infrastructure.ports.in.web.dto.response;

import java.math.BigDecimal;
import java.util.UUID;

public record IncomeResponseDto(UUID cd_income, String ds_income, BigDecimal vl_income) {
}
