package br.com.fiap.cashiq_backend.infrastructure.config;

import br.com.fiap.cashiq_backend.application.service.IncomeService;
import br.com.fiap.cashiq_backend.application.service.UserService;
import br.com.fiap.cashiq_backend.domain.port.out.Income.IncomeRepository;
import br.com.fiap.cashiq_backend.domain.port.out.User.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class ApplicationConfig {
    @Bean
    public IncomeService incomeService(IncomeRepository incomeRepository) {
        return new IncomeService(incomeRepository);
    }

    @Bean
    public UserService userService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return new UserService(userRepository, passwordEncoder);
    }
}
