package br.com.diogouoma.gestao_vagas.exceptions;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException() {
        super("Usuario não encontrado");
    }

}
