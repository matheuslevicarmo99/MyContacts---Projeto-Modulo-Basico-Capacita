package mycontacts.exceptions;

public class ContatoDuplicadoException extends RuntimeException{

    public ContatoDuplicadoException(String mensagem){
        super(mensagem);
    }
}
