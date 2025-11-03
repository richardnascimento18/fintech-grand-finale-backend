package br.com.fiap.cashiq_backend.infrastructure.model.Income;

import br.com.fiap.cashiq_backend.domain.model.Income;
import br.com.fiap.cashiq_backend.domain.port.out.Income.IncomeRepository;
import org.springframework.stereotype.Repository;

@Repository
public class IncomeRepositoryAdapter implements IncomeRepository {
    private final IncomeRepositoryImplementation incomeRepositoryImplementation;

    public IncomeRepositoryAdapter(IncomeRepositoryImplementation incomeRepositoryImplementation) {
        this.incomeRepositoryImplementation = incomeRepositoryImplementation;
    }

    @Override
    public void save(Income income) {
        IncomeImplementation incomeImplementation = new IncomeImplementation(income.getCd_income().toString(), income.getDs_income(), income.getVl_income(), income.getCd_user());
        incomeRepositoryImplementation.save(incomeImplementation);
    }
}
