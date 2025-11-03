package br.com.fiap.cashiq_backend.domain.model;

import java.math.BigDecimal;
import java.util.UUID;

public class Income {
    private final UUID cd_income;
    private final String ds_income;
    private final BigDecimal vl_income;
    private final String cd_user;

    public Income(UUID cd_income, String ds_income, BigDecimal vl_income, String cd_user) {
        this.cd_income = cd_income;
        this.ds_income = ds_income;
        this.vl_income = vl_income;
        this.cd_user = cd_user;
    }

    public Income(String ds_income, BigDecimal vl_income, String cd_user) {
        this.cd_income = UUID.randomUUID();
        this.ds_income = ds_income;
        this.vl_income = vl_income;
        this.cd_user = cd_user;
    }

    public UUID getCd_income() {
        return cd_income;
    }

    public String getDs_income() {
        return ds_income;
    }

    public BigDecimal getVl_income() {
        return vl_income;
    }

    public String getCd_user() {
        return cd_user;
    }
}
