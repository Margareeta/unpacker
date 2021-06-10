package org.max.exceptions;

public class LatinLetterException extends MyValidationException{
    public LatinLetterException (){
        super("Contains symbols other than latin letters and numbers");
    }
}
