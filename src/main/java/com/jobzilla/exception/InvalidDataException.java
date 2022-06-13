package com.jobzilla.exception;

public class InvalidDataException extends RuntimeException{
    public InvalidDataException() {super("Dados inválidos");}
}