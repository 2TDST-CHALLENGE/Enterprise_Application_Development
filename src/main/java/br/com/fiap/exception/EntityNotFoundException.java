package br.com.fiap.exception;

public class EntityNotFoundException extends Throwable {
    public EntityNotFoundException(){
        super("Usuário não encontrado!");
    }

    public EntityNotFoundException(String msg){
        super(msg);
    }
}
