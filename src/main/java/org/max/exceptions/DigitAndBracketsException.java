package org.max.exceptions;

public class DigitAndBracketsException extends MyValidationException {
    public DigitAndBracketsException () {
        super("No bracket between a number and a letter");
    }

}
