package br.com.fiap.cashiq_backend.infrastructure.model.Income;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeRepositoryImplementation extends JpaRepository<IncomeImplementation, String> {}
