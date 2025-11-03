package br.com.fiap.cashiq_backend.domain.port.out.User;

import br.com.fiap.cashiq_backend.domain.model.User;

public interface UserServiceInterface {
    User save(String email_user, String password_user, String confirmPassword);
}
