package br.com.fiap.cashiq_backend.infrastructure.model.Expense;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepositoryImplementation extends JpaRepository<ExpenseImplementation, String> {
    Page<ExpenseImplementation> findAllByCdUserOrderByCdExpenseDesc(String cdUser, Pageable pageable);
}
