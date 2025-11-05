package br.com.fiap.cashiq_backend.infrastructure.model.Income;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeRepositoryImplementation extends JpaRepository<IncomeImplementation, String> {
    Page<IncomeImplementation> findAllByCdUserOrderByCdIncomeDesc(String cdUser, Pageable pageable);
}
