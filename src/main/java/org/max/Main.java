package org.max;

import org.max.domain.UnpackerString;
import org.max.exceptions.*;

public class Main {
    public static void main(String[] args) {
        UnpackerString unpackerString = new UnpackerString();
        try {
            System.out.println(unpackerString.unpack("4[abc]de4[2[fg]qw]"));
        } catch (SpaceException e) {
            System.out.println("Ошибка ввода, строка не должна содержать пробелы");
        } catch (LatinLetterException e1) {
            System.out.println("Ошибка ввода, строка не должна содержать ничего, кроме латинских" +
                    "букв, цифр и квадратных скобок!");
        } catch (DigitAndBracketsException e2){
            System.out.println("Ошибка ввода, скобка должна следовать за цифрой!");
        }catch (PairOfBracketsException e3) {
            System.out.println("Ошибка ввода, скобки непарные!");
        } catch (MyValidationException e4) {

        }
    }
}
