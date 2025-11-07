package br.com.fiap.cashiq_backend.domain.model;

import java.math.BigDecimal;
import java.util.UUID;

public class Expense {
    private final UUID cd_expense;
    private final String ds_expense;
    private final BigDecimal vl_expense;
    private final String cd_user;

    public Expense(UUID cd_expense, String ds_expense, BigDecimal vl_expense, String cd_user) {
        this.cd_expense = cd_expense;
        this.ds_expense = ds_expense;
        this.vl_expense = vl_expense;
        this.cd_user = cd_user;
    }

    public Expense(String ds_expense, BigDecimal vl_expense, String cd_user) {
        this.cd_expense = UUID.randomUUID();
        this.ds_expense = ds_expense;
        this.vl_expense = vl_expense;
        this.cd_user = cd_user;
    }

    public UUID getCd_expense() {
        return cd_expense;
    }

    public String getDs_expense() {
        return ds_expense;
    }

    public BigDecimal getVl_expense() {
        return vl_expense;
    }

    public String getCd_user() {
        return cd_user;
    }
}
