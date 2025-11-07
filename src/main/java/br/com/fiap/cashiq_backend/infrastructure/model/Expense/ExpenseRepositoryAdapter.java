package br.com.fiap.cashiq_backend.infrastructure.model.Expense;

import br.com.fiap.cashiq_backend.domain.model.Expense;
import br.com.fiap.cashiq_backend.domain.port.out.Expense.ExpenseRepository;
import br.com.fiap.cashiq_backend.infrastructure.helper.ConverterHelper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ExpenseRepositoryAdapter implements ExpenseRepository {
    private final ExpenseRepositoryImplementation expenseRepositoryImplementation;

    public ExpenseRepositoryAdapter(ExpenseRepositoryImplementation expenseRepositoryImplementation) {
        this.expenseRepositoryImplementation = expenseRepositoryImplementation;
    }

    @Override
    public void save(Expense expense) {
        ExpenseImplementation expenseImplementation = new ExpenseImplementation(expense.getCd_expense().toString(), expense.getDs_expense(), expense.getVl_expense(), expense.getCd_user());
        expenseRepositoryImplementation.save(expenseImplementation);
    }

    @Override
    public List<Expense> findAllByCdUser(int page, String cdUser) {
        Pageable pageable = PageRequest.of(page, 10, Sort.by("cdExpense").descending());
        Page<ExpenseImplementation> expensePage = expenseRepositoryImplementation.findAllByCdUserOrderByCdExpenseDesc(cdUser, pageable);
        List<Expense> expenseList = new ArrayList<>();

        expensePage.forEach(expense -> {
            expenseList.add(new Expense(ConverterHelper.uuidFromHexString(expense.getCd_expense()), expense.getDsExpense(), expense.getVlExpense(), expense.getCdUser()));
        });

        return expenseList;
    }

    @Override
    public void deleteByCdExpense(String cdExpense) {
        expenseRepositoryImplementation.deleteById(cdExpense);
    }
}
