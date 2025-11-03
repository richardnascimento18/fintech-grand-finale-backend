package br.com.fiap.cashiq_backend.infrastructure.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepositoryImplementation extends JpaRepository<UserImplementation, UUID> {
}
