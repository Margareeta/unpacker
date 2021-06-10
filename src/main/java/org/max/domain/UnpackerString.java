package org.max.domain;

import org.max.exceptions.MyValidationException;
import org.max.validator.Validator;
import org.max.validator.ValidatorImpl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UnpackerString {
    public final static String REGEX_FOR_MULTIPLYER = "\\[\\w+\\]";
    public final static String REGEX_FOR_UNPACK = "\\d+\\[\\w+\\]";
    private Validator validator;


    public String stringMultiplyer(String input) {
        StringBuilder result = new StringBuilder();
        int ratio = Integer.parseInt(input.replaceAll(REGEX_FOR_MULTIPLYER, ""));
        String smallString = input.substring(input.indexOf('[') + 1, input.indexOf(']'));

        for (int i = 0; i < ratio; i++) {
            result.append(smallString);
        }
        String result1 = result.toString();

        return result1;
    }


    public String unpack(String input) throws MyValidationException {
        validator = new ValidatorImpl(input);
        validator.fullValidation();
        Pattern pattern = Pattern.compile(REGEX_FOR_UNPACK);
        StringBuilder stringBuilder = new StringBuilder();


        while (true) {
        Matcher matcher = pattern.matcher(input);
        if(!matcher.find())
        break;
        String result = stringMultiplyer(matcher.group());
        input = matcher.replaceFirst(result);

      }
        return input;

    }
}
