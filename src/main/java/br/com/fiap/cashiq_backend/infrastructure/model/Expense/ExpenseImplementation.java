package br.com.fiap.cashiq_backend.infrastructure.model.Expense;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "TB_EXPENSE")
public class ExpenseImplementation {

    @Id
    @Column(name = "CD_EXPENSE")
    private String cdExpense;

    @Column(name = "DS_EXPENSE", nullable = false)
    private String dsExpense;

    @Column(name = "VL_EXPENSE", nullable = false)
    private BigDecimal vlExpense;

    @Column(name = "CD_USER", nullable = false)
    private String cdUser;

    public ExpenseImplementation() {}

    public ExpenseImplementation(String cdExpense, String dsExpense, BigDecimal vlExpense, String cdUser) {
        this.cdExpense = cdExpense;
        this.dsExpense = dsExpense;
        this.vlExpense = vlExpense;
        this.cdUser = cdUser;
    }

    public String getCd_expense() {
        return cdExpense;
    }

    public void setCdExpense(String cdExpense) {
        this.cdExpense = cdExpense;
    }

    public String getDsExpense() {
        return dsExpense;
    }

    public void setDsExpense(String dsExpense) {
        this.dsExpense = dsExpense;
    }

    public BigDecimal getVlExpense() {
        return vlExpense;
    }

    public void setVlExpense(BigDecimal vlExpense) {
        this.vlExpense = vlExpense;
    }

    public String getCdUser() {
        return cdUser;
    }

    public void setCdUser(String cdUser) {
        this.cdUser = cdUser;
    }
}

