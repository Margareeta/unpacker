package org.max.validator;

import org.max.exceptions.*;

public interface Validator {
    void latinLettersValidation() throws LatinLetterException;
    void digitAndBracketsValidation() throws DigitAndBracketsException;
    void pairOfBracketsValidation() throws PairOfBracketsException;
    void spaceValidation() throws SpaceException;
    void fullValidation() throws PairOfBracketsException, SpaceException, DigitAndBracketsException, LatinLetterException, MyValidationException;

}
