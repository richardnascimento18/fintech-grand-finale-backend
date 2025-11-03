package br.com.fiap.cashiq_backend.infrastructure.model.User;

import br.com.fiap.cashiq_backend.domain.model.User;
import br.com.fiap.cashiq_backend.domain.port.out.User.UserRepository;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryAdapter implements UserRepository {
    private final UserRepositoryImplementation userRepositoryImplementation;

    public UserRepositoryAdapter(UserRepositoryImplementation userRepositoryImplementation) {
        this.userRepositoryImplementation = userRepositoryImplementation;
    }

    @Override
    public void save(User user) {
        UserImplementation userImplementation = new UserImplementation(user.getCd_user().toString(), user.getEmail_user(), user.getPassword_user());
        userRepositoryImplementation.save(userImplementation);
    }
}
