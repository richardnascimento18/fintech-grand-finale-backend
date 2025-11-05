package br.com.fiap.cashiq_backend.domain.port.out.Income;

import br.com.fiap.cashiq_backend.domain.model.Income;

import java.math.BigDecimal;
import java.util.List;

public interface IncomeServiceInterface {
    Income save(String ds_income, BigDecimal vl_income, String cd_user);
    List<Income> findAllByCdUser(int page, String cdUser);
}
