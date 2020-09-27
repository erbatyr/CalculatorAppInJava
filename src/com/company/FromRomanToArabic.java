package com.company;

public class FromRomanToArabic {
    public boolean isValidArabic(int x) {
        String num = String.valueOf(x);

        //      rover9em kajdyi character na tsifry
        for (int k = 0; k < num.length(); k++) {
            if (!Character.isDigit(num.charAt(k))) {
                return false;
            }
        }

        //  checkaem 4islo na mejdu ot 1 do 3999
        return x <= 3999 && x >= 1;
    }

    //    prover9em rimskie tsifry na validnost'
    public boolean isValidRoman(String num) {
        //    checkaem est' li tut rimskie tsifry
        for (int k = 0; k < num.length(); k++) {
            if (num.charAt(k) != 'I' &&
            num.charAt(k) != 'V' &&
            num.charAt(k) != 'X' &&
            num.charAt(k) != 'L' &&
            num.charAt(k) != 'C' &&
            num.charAt(k) != 'D' &&
            num.charAt(k) != 'M') {
                return false;
            }
        }
        return true;
    }

    //   iz arabskogo v rimskii
    public String toRoman(int num) {
        if (isValidArabic(num)) {  //      prover9em na validnost' arabckih tsifr
            StringBuilder Roman = new StringBuilder(); //      eto budet naw return
            //    nawi unikalnye rimskie tsifry
            String[] onesArray = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
            String[] tensArray = {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
            String[] hundredsArray = {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
            //    4isla do 10
            int ones = num % 10;

            //    des9tki
            num = (num - ones) / 10;
            int tens = num % 10;

            //    sotki
            num = (num - tens) / 10;
            int hundreds = num % 10;

            //    tys94niki
            num = (num - hundreds) / 10;
            Roman.append("M".repeat(Math.max(0, num)));

            //piwem vse eti tsifry v array
            if (hundreds >= 1) {
                Roman.append(hundredsArray[hundreds - 1]);
            }
            if (tens >= 1) {
                Roman.append(tensArray[tens - 1]);
            }
            if (ones >= 1) {
                Roman.append(onesArray[ones - 1]);
            }

            //    vozvrawaem string
            return Roman.toString();
        } else {
            return null;    //esli tsifry ne arabskie vozvrawaem null
        }
    }

    //      teper' v arabskuiu
    public String toArabic(String s) {

        if (isValidRoman(s)) {      //prover9em validnost' na rimskie tsifry

            int Arabic = 0;     //eto naw rezultat
            int last_digit = 0;
            int current_digit = 0;

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'I') {
                    current_digit = 1;
                }
                if (s.charAt(i) == 'V') {
                    current_digit = 5;
                }
                if (s.charAt(i) == 'X') {
                    current_digit = 10;
                }
                if (s.charAt(i) == 'L') {
                    current_digit = 50;
                }
                if (s.charAt(i) == 'C') {
                    current_digit = 100;
                }
                if (s.charAt(i) == 'D') {
                    current_digit = 500;
                }
                if (s.charAt(i) == 'M') {
                    current_digit = 1000;
                }

                //esli last number men'we current number, to vy4ityvaem last number from current number
                //elsi net to, dobavl9em current number. My takje doljny propustit' first  number iz etogo pravila
                if (last_digit < current_digit && last_digit != 0) {
                    current_digit -= last_digit;
                    Arabic -= last_digit;
                    Arabic += current_digit;
                    last_digit = current_digit;
                } else {
                    last_digit = current_digit;
                    Arabic += current_digit;
                }
                current_digit = 0;
            }

            //vozvrawaem string
            return String.valueOf(Arabic);
        } else {
            return null;        //esli tsifry ne rimskie vozvrawaem null
        }
    }
}