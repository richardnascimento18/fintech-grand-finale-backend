package br.com.fiap.cashiq_backend.domain.model;

import java.util.UUID;

public class User {
    private UUID cd_user;
    private String email_user;
    private String password_user;

    public User(String email_user, String password_user) {
        this.cd_user = UUID.randomUUID();
        this.email_user = email_user;
        this.password_user = password_user;
    }

    public UUID getCd_user() {
        return cd_user;
    }

    public String getEmail_user() {
        return email_user;
    }

    public String getPassword_user() {
        return password_user;
    }
}
