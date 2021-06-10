package org.max.validator;

import org.max.exceptions.*;

import java.lang.reflect.Array;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorImpl implements Validator{

    private String input;

    public ValidatorImpl(String input){

        this.input = input;
    }

    @Override
    public void latinLettersValidation() throws LatinLetterException {

      String result = "";
      String result1 = "";
      String result2 = "";

      Pattern pattern = Pattern.compile("[^A-Za-z]");
      Matcher matcher = pattern.matcher(input);
      while (matcher.find()){
        result +=  matcher.group();//4[я]
      }
      pattern = Pattern.compile("[^\\d]");
      matcher = pattern.matcher(result);
        while (matcher.find()){
            result1 += matcher.group();
        }//[я]

        pattern = Pattern.compile("(\\[|])*");
        matcher = pattern.matcher(result1);
        while (matcher.find()){
            result2 = matcher.replaceAll("");
        }

      if (result2.length() != 0){
          throw new  LatinLetterException();
      }

    }

    @Override
    public void digitAndBracketsValidation() throws DigitAndBracketsException{
        String digitAndBracketRegEx = "(\\d)+[A-Za-z]";
        Pattern pattern = Pattern.compile(digitAndBracketRegEx);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            throw new DigitAndBracketsException();
        }

    }

    @Override
    public void pairOfBracketsValidation() throws PairOfBracketsException {

        int countOfLeftBracket = 0;
        int countOfRightBracket = 0;
        String LEFT_BRACKETS_REGEX = "\\[";
        String RIGHT_BRACKETS_REGEX = "\\]";
        Pattern pattern = Pattern.compile(LEFT_BRACKETS_REGEX);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            countOfLeftBracket++;
        }
        Pattern pattern1 = Pattern.compile(RIGHT_BRACKETS_REGEX);
        Matcher matcher1 = pattern1.matcher(input);
        while (matcher1.find() && input.indexOf('[') < input.indexOf(']')){
            countOfRightBracket++;
        }
        if (countOfLeftBracket != countOfRightBracket || input.indexOf('[') > input.indexOf(']')){
            throw new PairOfBracketsException();
        }
    }

    @Override
    public void spaceValidation() throws SpaceException {
        final String SPACE_REGEX = "\\s+";
        Pattern pattern = Pattern.compile(SPACE_REGEX);
        Matcher matcher = pattern.matcher(input);
        if(matcher.find()) {
            throw new SpaceException();
        }

    }

    @Override
    public void fullValidation() throws MyValidationException {
        digitAndBracketsValidation();
        pairOfBracketsValidation();
        spaceValidation();
        latinLettersValidation();

    }

}
