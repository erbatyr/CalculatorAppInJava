package com.company;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println("Введите числа и операцию в формате: 4 + 4");
        String a = sc.nextLine();
        calc.setInput(a);
        String operation = calc.getOperation();
        if (calc.isArabic(a)) {
            System.out.println("String is Arabic");
            int[] numbers = calc.getArabicNumbers();
            System.out.println(calc.calculate(numbers, operation));
        } else {
            System.out.println("String is not Arabic");
            String[] numbers = calc.getRomanNumbers();
            System.out.println(calc.calculate(numbers, operation));
        }
    }
}
class Calculator {
    private String input;

    //    setter dl9 input
    public void setInput(String input) {
        this.input = input;
    }

    //    polu4aem arifmeti4eskuiu operatsiu iz input
    public String getOperation() {
        String[] splittedInput = input.split(" ");
        return splittedInput[1];
    }

    //    metod dl9 polu4enie arabskih tsifr
    public int[] getArabicNumbers() {
        int[] arabicNumbers = new int[2];
        String[] splittedInput = input.split(" ");
        arabicNumbers[0] = Integer.parseInt(splittedInput[0]);
        arabicNumbers[1] = Integer.parseInt(splittedInput[2]);
        return arabicNumbers;
    }

    //    metod dl9 polu4enie rimskih tsifr
    public String[] getRomanNumbers() {
        String[] romanNumbers = new String[2];
        String[] splittedInput = input.split(" ");
        romanNumbers[0] = splittedInput[0];
        romanNumbers[1] = splittedInput[2];
        return romanNumbers;
    }

    // metod proverki arabskii  ili net?!
    public boolean isArabic(String input) {
        char[] inputChars = input.toCharArray();
        return Character.isDigit(inputChars[0]);
    }

    // arifmeti4eskie operatsii , zdes' 1yi parametr array tsifr
    public int calculate(int[] numbers, String operation) {
        int result;
        if (operation.charAt(0)=="+".charAt(0)) {
            result = numbers[0] + numbers[1];
        } else if (operation.charAt(0)=="-".charAt(0)) {
            result = numbers[0] - numbers[1];
        } else if (operation.charAt(0)=="*".charAt(0)) {
            result = numbers[0] * numbers[1];
        } else if (operation.charAt(0)=="/".charAt(0)) {
            result = numbers[0] / numbers[1];
        } else {
            result = -1;
        }
        return result;
    }

    // arifmeti4eskie operatsii , zdes' 1yi parametr array String-ov
    public String calculate(String[] romanNumbers, String operation) {
        int result;
        int[] numbers = new int[2];
        FromRomanToArabic frta = new FromRomanToArabic();   //sozdaem ob'ekt klassa FromRomanToArabic
        numbers[0] = Integer.parseInt(frta.toArabic(romanNumbers[0]));   //perevodim s rimskogo na arabic i dobavl9em v array
        numbers[1] = Integer.parseInt(frta.toArabic(romanNumbers[1]));   //perevodim s rimskogo na arabic i dobavl9em v array

        if (operation.charAt(0)=="+".charAt(0)) {
            result = numbers[0] + numbers[1];
        } else if (operation.charAt(0)=="-".charAt(0)) {
            result = numbers[0] - numbers[1];
        } else if (operation.charAt(0)=="*".charAt(0)) {
            result = numbers[0] * numbers[1];
        } else if (operation.charAt(0)=="/".charAt(0)) {
            result = numbers[0] / numbers[1];
        } else {
            result = -1; //esli operatsii ne sovpadaiut polu4aem -1
        }
        FromRomanToArabic b = new FromRomanToArabic(); //sozdaem ob'ekt klassa FromRomanToArabic
        return b.toRoman(result);   //perevodim s arabskogo na rimskii
    }
}