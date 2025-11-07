package br.com.fiap.cashiq_backend.application.service;

import br.com.fiap.cashiq_backend.domain.exceptions.PasswordDoNotCoincideException;
import br.com.fiap.cashiq_backend.domain.model.User;
import br.com.fiap.cashiq_backend.domain.port.out.User.UserRepository;
import br.com.fiap.cashiq_backend.domain.port.out.User.UserServiceInterface;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserService implements UserServiceInterface {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User save(String email_user, String password_user, String confirmPassword) {
        if(!confirmPassword.equals(password_user)) throw new PasswordDoNotCoincideException();
        String hashedPassword = passwordEncoder.encode(password_user);

        User user = new User(email_user, hashedPassword);
        userRepository.save(user);
        return user;
    }

    @Override
    public User login(String email_user, String password_user) {
        User user = userRepository.findByEmail(email_user);

        if(user == null) throw new RuntimeException();
        if(!passwordEncoder.matches(password_user, user.getPassword_user())) throw new RuntimeException();

        return user;
    }
}
