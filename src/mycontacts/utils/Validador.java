package mycontacts.utils;

import mycontacts.exceptions.FormatoInvalidoException;

public class Validador {


    public static void validarEmail(String email){
        if(!email.contains("@") || !email.contains(".")){
            throw new FormatoInvalidoException("E-mail inválido! Deve conter @ e um domínio.");
        }
    }

    public static void validarTelefone(String telefone){
        if(telefone.length() < 10 || telefone.length() > 11){
            throw new FormatoInvalidoException("Telefone inválido! Deve conter 11 números !");
        } else if (!telefone.matches("[0-9]+")) {
            throw new FormatoInvalidoException("Telefone Inválido ! Deve conter apenas números com o DDD");
        }
    }
}
