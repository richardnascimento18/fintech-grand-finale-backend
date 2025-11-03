package br.com.fiap.cashiq_backend.domain.port.out.User;

import br.com.fiap.cashiq_backend.domain.model.User;

public interface UserRepository {
    void save(User user);
}
