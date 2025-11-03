package br.com.fiap.cashiq_backend.infrastructure.model.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_USER")
public class UserImplementation {
    @Id
    @Column(name = "CD_USER")
    private String cd_user;

    @Column(name = "EMAIL_USER")
    private String email_user;

    @Column(name = "PSW_USER")
    private String password_user;

    public UserImplementation() {}

    public UserImplementation(String cd_user, String email_user, String password_user) {
        this.cd_user = cd_user;
        this.email_user = email_user;
        this.password_user = password_user;
    }

    public String getCd_user() {
        return cd_user;
    }

    public void setCd_user(String cd_user) {
        this.cd_user = cd_user;
    }

    public String getEmail_user() {
        return email_user;
    }

    public void setEmail_user(String email_user) {
        this.email_user = email_user;
    }

    public String getPassword_user() {
        return password_user;
    }

    public void setPassword_user(String password_user) {
        this.password_user = password_user;
    }
}
