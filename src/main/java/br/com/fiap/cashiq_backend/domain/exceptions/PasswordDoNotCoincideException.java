package br.com.fiap.cashiq_backend.domain.exceptions;

public class PasswordDoNotCoincideException extends RuntimeException {
    public PasswordDoNotCoincideException() {
        super("PASSWORDS_DO_NOT_COINCIDE");
    }
}
