package br.com.fiap.cashiq_backend.domain.port.out.Expense;

import br.com.fiap.cashiq_backend.domain.model.Expense;

import java.math.BigDecimal;
import java.util.List;

public interface ExpenseServiceInterface {
    Expense save(String ds_income, BigDecimal vl_income, String cd_user);
    List<Expense> findAllByCdUser(int page, String cdUser);
    void deleteByCdExpense(String cdExpense);
}
