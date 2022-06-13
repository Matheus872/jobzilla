package com.jobzilla.exception;

public class ExistingEmailException extends RuntimeException{
    public ExistingEmailException(){ super("Email já cadastrado");}
}