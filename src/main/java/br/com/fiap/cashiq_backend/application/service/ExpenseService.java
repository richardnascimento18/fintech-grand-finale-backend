package br.com.fiap.cashiq_backend.application.service;

import br.com.fiap.cashiq_backend.domain.model.Expense;
import br.com.fiap.cashiq_backend.domain.port.out.Expense.ExpenseRepository;
import br.com.fiap.cashiq_backend.domain.port.out.Expense.ExpenseServiceInterface;

import java.math.BigDecimal;
import java.util.List;

public class ExpenseService implements ExpenseServiceInterface {
    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public Expense save(String ds_expense, BigDecimal vl_expense, String cd_user) {
        Expense expense = new Expense(ds_expense, vl_expense, cd_user);

        expenseRepository.save(expense);
        return expense;
    }

    @Override
    public List<Expense> findAllByCdUser(int page, String cdUser) {
        return expenseRepository.findAllByCdUser(page, cdUser);
    }

    @Override
    public void deleteByCdExpense(String cdExpense) {
        expenseRepository.deleteByCdExpense(cdExpense);
    }
}
