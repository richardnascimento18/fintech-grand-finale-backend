package br.com.fiap.cashiq_backend.domain.port.out.Income;

import br.com.fiap.cashiq_backend.domain.model.Income;

public interface IncomeRepository {
    void save(Income income);
}
