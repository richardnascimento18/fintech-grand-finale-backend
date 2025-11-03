package br.com.fiap.cashiq_backend.infrastructure.model.Income;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "TB_INCOME")
public class IncomeImplementation {

    @Id
    @Column(name = "CD_INCOME")
    private String cd_income;

    @Column(name = "DS_INCOME", nullable = false)
    private String ds_income;

    @Column(name = "VL_INCOME", nullable = false)
    private BigDecimal vl_income;

    @Column(name = "CD_USER", nullable = false)
    private String cd_user;

    public IncomeImplementation() {}

    public IncomeImplementation(String cd_income, String ds_income, BigDecimal vl_income, String cd_user) {
        this.cd_income = cd_income;
        this.ds_income = ds_income;
        this.vl_income = vl_income;
        this.cd_user = cd_user;
    }

    public String getCd_income() {
        return cd_income;
    }

    public void setCd_income(String cd_income) {
        this.cd_income = cd_income;
    }

    public String getDs_income() {
        return ds_income;
    }

    public void setDs_income(String ds_income) {
        this.ds_income = ds_income;
    }

    public BigDecimal getVl_income() {
        return vl_income;
    }

    public void setVl_income(BigDecimal vl_income) {
        this.vl_income = vl_income;
    }

    public String getCd_user() {
        return cd_user;
    }

    public void setCd_user(String cd_user) {
        this.cd_user = cd_user;
    }
}

