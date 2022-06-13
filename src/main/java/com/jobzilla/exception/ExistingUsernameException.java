package com.jobzilla.exception;

public class ExistingUsernameException extends RuntimeException{
    public ExistingUsernameException(){ super("Nome de Usuário já cadastrado");}
}