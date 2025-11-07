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
    private String cdUser;

    @Column(name = "EMAIL_USER")
    private String emailUser;

    @Column(name = "PSW_USER")
    private String passwordUser;

    public UserImplementation() {}

    public UserImplementation(String cdUser, String emailUser, String passwordUser) {
        this.cdUser = cdUser;
        this.emailUser = emailUser;
        this.passwordUser = passwordUser;
    }

    public String getCdUser() {
        return cdUser;
    }

    public void setCdUser(String cdUser) {
        this.cdUser = cdUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }
}
