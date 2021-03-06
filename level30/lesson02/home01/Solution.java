package com.javarush.test.level30.lesson02.home01;
import java.math.BigInteger;

/* Конвертер систем счислений
Реализуйте логику метода convertNumberToOtherNumerationSystem, который должен переводить число number.getDigit()
из одной системы счисления(numerationSystem) в другую (expectedNumerationSystem)
бросьте NumberFormatException, если переданное число некорректно, например, число "120" с системой счисления 2
Валидация для - number.getDigit() - целое не отрицательное
Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        Number number = new Number(NumerationSystemType._10, "6");
        Number result = convertNumberToOtherNumerationSystem(number, NumerationSystemType._2);
        System.out.println(result);    //expected 110

        Number number2 = new Number(NumerationSystemType._2, "110");
        Number result2 = convertNumberToOtherNumerationSystem(number2, NumerationSystemType._10);
        System.out.println(result2);    //expected 6

        Number number3 = new Number(NumerationSystemType._10, "1543562");
        Number result3 = convertNumberToOtherNumerationSystem(number3, NumerationSystemType._16);
        System.out.println(result3);    //expected 178D8A

        Number number4 = new Number(NumerationSystemType._16, "178D8A");
        Number result4 = convertNumberToOtherNumerationSystem(number4, NumerationSystemType._10);
        System.out.println(result4);    //expected 1543562

        Number number5 = new Number(NumerationSystemType._12, "178B8A");
        Number result5 = convertNumberToOtherNumerationSystem(number5, NumerationSystemType._10);
        System.out.println(result5);    //expected 409498
    }

    public static Number convertNumberToOtherNumerationSystem(Number number, NumerationSystem expectedNumerationSystem) {
        int numerationSystem = number.getNumerationSystem().getNumerationSystemIntValue();
        char[] digitAsCharArray = number.getDigit().toCharArray();
        boolean mark = true;
        String numeralSystem12 = "0123456789AB", numeralSystem16 = "0123456789ABCDEF";

        for (char c : digitAsCharArray) {
            if (numerationSystem > 1 && numerationSystem <= 10) {
                if (Character.getNumericValue(c) < numerationSystem)
                    mark = true;
                else
                    mark = false;
            }
            else if (numerationSystem == 12) {
                if (numeralSystem12.toLowerCase().contains(String.valueOf(c).toLowerCase()))
                    mark = true;
                else
                    mark = false;
            }
            else if (numerationSystem == 16) {
                if (numeralSystem16.toLowerCase().contains(String.valueOf(c).toLowerCase()))
                    mark = true;
                else
                    mark = false;
            }
        }
        if (mark) {
            return new Number(expectedNumerationSystem, new BigInteger(number.getDigit(), number.getNumerationSystem().getNumerationSystemIntValue()).toString(expectedNumerationSystem.getNumerationSystemIntValue()));
        } else {
            throw new NumberFormatException();
        }

    }
}
