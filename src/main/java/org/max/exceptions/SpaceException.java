package org.max.exceptions;

public class SpaceException extends MyValidationException {
    public SpaceException(){
        super("Contains Space symbol.");
    }
}

