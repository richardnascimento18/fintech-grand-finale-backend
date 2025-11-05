package br.com.fiap.cashiq_backend.infrastructure.model.Income;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "TB_INCOME")
public class IncomeImplementation {

    @Id
    @Column(name = "CD_INCOME")
    private String cdIncome;

    @Column(name = "DS_INCOME", nullable = false)
    private String dsIncome;

    @Column(name = "VL_INCOME", nullable = false)
    private BigDecimal vlIncome;

    @Column(name = "CD_USER", nullable = false)
    private String cdUser;

    public IncomeImplementation() {}

    public IncomeImplementation(String cdIncome, String dsIncome, BigDecimal vlIncome, String cdUser) {
        this.cdIncome = cdIncome;
        this.dsIncome = dsIncome;
        this.vlIncome = vlIncome;
        this.cdUser = cdUser;
    }

    public String getCd_income() {
        return cdIncome;
    }

    public void setCdIncome(String cdIncome) {
        this.cdIncome = cdIncome;
    }

    public String getDsIncome() {
        return dsIncome;
    }

    public void setDsIncome(String dsIncome) {
        this.dsIncome = dsIncome;
    }

    public BigDecimal getVlIncome() {
        return vlIncome;
    }

    public void setVlIncome(BigDecimal vlIncome) {
        this.vlIncome = vlIncome;
    }

    public String getCdUser() {
        return cdUser;
    }

    public void setCdUser(String cdUser) {
        this.cdUser = cdUser;
    }
}

