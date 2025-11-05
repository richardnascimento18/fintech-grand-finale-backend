package br.com.fiap.cashiq_backend.infrastructure.model.Income;

import br.com.fiap.cashiq_backend.domain.model.Income;
import br.com.fiap.cashiq_backend.domain.port.out.Income.IncomeRepository;
import br.com.fiap.cashiq_backend.infrastructure.helper.ConverterHelper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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

    @Override
    public List<Income> findAllByCdUser(int page, String cdUser) {
        Pageable pageable = PageRequest.of(page, 10, Sort.by("cdIncome").descending());
        Page<IncomeImplementation> incomePage = incomeRepositoryImplementation.findAllByCdUserOrderByCdIncomeDesc(cdUser, pageable);
        List<Income> incomeList = new ArrayList<>();

        incomePage.forEach(income -> {
            incomeList.add(new Income(ConverterHelper.uuidFromHexString(income.getCd_income()), income.getDsIncome(), income.getVlIncome(), income.getCdUser()));
        });

        return incomeList;
    }

    @Override
    public void deleteByCdIncome(String cdIncome) {
        incomeRepositoryImplementation.deleteById(cdIncome);
    }
}
