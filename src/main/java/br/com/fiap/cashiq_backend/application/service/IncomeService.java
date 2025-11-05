package br.com.fiap.cashiq_backend.application.service;

import br.com.fiap.cashiq_backend.domain.model.Income;
import br.com.fiap.cashiq_backend.domain.port.out.Income.IncomeRepository;
import br.com.fiap.cashiq_backend.domain.port.out.Income.IncomeServiceInterface;

import java.math.BigDecimal;
import java.util.List;

public class IncomeService implements IncomeServiceInterface {
    private final IncomeRepository incomeRepository;

    public IncomeService(IncomeRepository incomeRepository) {
        this.incomeRepository = incomeRepository;
    }

    public Income save(String ds_income, BigDecimal vl_income, String cd_user) {
        Income income = new Income(ds_income, vl_income, cd_user);

        incomeRepository.save(income);
        return income;
    }

    @Override
    public List<Income> findAllByCdUser(int page, String cdUser) {
        return incomeRepository.findAllByCdUser(page, cdUser);
    }
}
