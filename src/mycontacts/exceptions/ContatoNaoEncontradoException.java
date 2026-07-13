package mycontacts.exceptions;

public class ContatoNaoEncontradoException extends RuntimeException{

    public ContatoNaoEncontradoException(String mensagem){
        super(mensagem);
    }
}
