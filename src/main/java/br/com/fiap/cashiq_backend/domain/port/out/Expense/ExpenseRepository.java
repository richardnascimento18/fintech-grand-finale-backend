package br.com.fiap.cashiq_backend.domain.port.out.Expense;

import br.com.fiap.cashiq_backend.domain.model.Expense;

import java.util.List;

public interface ExpenseRepository {
    void save(Expense income);
    List<Expense> findAllByCdUser(int page, String cdUser);
    void deleteByCdExpense(String cdIncome);
}
