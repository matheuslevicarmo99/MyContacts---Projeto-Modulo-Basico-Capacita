package mycontacts.utils;

import mycontacts.exceptions.FormatoInvalidoException;

public class Validador {

    public static void validarTelefone(String telefone) throws FormatoInvalidoException {
        if (telefone == null || !telefone.matches("\\d{11}")) {
            throw new FormatoInvalidoException("O telefone deve conter exatamente 11 números (DDD + 9 dígitos), sem espaços ou traços.");
        }
    }

    public static void validarEmail(String email) throws FormatoInvalidoException {
        if (email == null || !email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            throw new FormatoInvalidoException("Formato de e-mail inválido. Verifique se contém '@' e '.com'.");
        }
    }
}