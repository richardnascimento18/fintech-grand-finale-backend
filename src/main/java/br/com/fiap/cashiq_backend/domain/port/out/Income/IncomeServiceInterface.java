package br.com.fiap.cashiq_backend.domain.port.out.Income;

import br.com.fiap.cashiq_backend.domain.model.Income;

import java.math.BigDecimal;

public interface IncomeServiceInterface {
    Income save(String ds_income, BigDecimal vl_income, String cd_user);
}
