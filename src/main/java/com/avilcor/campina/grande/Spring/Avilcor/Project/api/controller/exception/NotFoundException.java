package com.avilcor.campina.grande.Spring.Avilcor.Project.api.controller.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
