package br.com.fiap.cashiq_backend.domain.port.out.Income;

import br.com.fiap.cashiq_backend.domain.model.Income;

import java.util.List;

public interface IncomeRepository {
    void save(Income income);
    List<Income> findAllByCdUser(int page, String cdUser);
}
