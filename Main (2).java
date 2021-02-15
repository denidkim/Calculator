package com.pagemaster;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static String[] romanNumbers = {
        "I","II","III","IV","V","VI","VII","VIII","IX","X",
        "XI","XII","XIII","XIV","XV","XVI","XVII","XVIII","XIX","XX",
        "XXI","XXII","XXIII","XXIV","XXV","XXVI","XXVII","XXVIII","XXIX","XXX",
        "XXXI","XXXII","XXXIII","XXXIV","XXXV","XXXVI","XXXVII","XXXVIII","XXXIX","XL",
        "XLI","XLII","XLIII","XLIV","XLV","XLVI","XLVII","XLVIII","XLIX","L",
        "LI","LII","LIII","LIV","LV","LVI","LVII","LVIII","LIX","LX",
        "LXI","LXII","LXIII","LXIV","LXV","LXVI","LXVII","LXVIII","LXIX","LXX",
        "LXXI","LXXII","LXXIII","LXXIV","LXXV","LXXVI","LXXVII","LXXVIII","LXXIX","LXXX",
        "LXXXI","LXXXII","LXXXIII","LXXXIV","LXXXV","LXXXVI","LXXXVII","LXXXVIII","LXXXIX","XC",
        "XCI","XCII","XCIII","XCIV","XCV","XCVI","XCVII","XCVIII","XCIX","C",
    };
    public static boolean isRoman(String str) {
        for(String item : romanNumbers)
            if(item.equals(str.toUpperCase()))
                return true;
        return false;
    }
    public static int findIndex(String str) {
        for(int i = 0; i < romanNumbers.length; i++)
            if(romanNumbers[i].equals(str.toUpperCase()))
                return i;
        return -1;
    }
    public static int toArab(String str) {
        int index = findIndex(str);
        if(index == -1)
            throw new RuntimeException("Error");
        return index + 1;
    }
    public static boolean isArab(String str) {
        for(int i = 0; i < str.length(); i++)
            if(!(str.charAt(i) >= '0' && str.charAt(i) <= '9'))
                return false;
        return true;
    }
    public static void program(String str) {
        if(str.length() == 0)
            throw new RuntimeException("Error");
        String[] sub = str.split(" ");
        String result = "";
        if(sub.length == 0 || sub.length > 3)
            throw new RuntimeException("Error");
        String lhs = sub[0];
        String oper = sub[1];
        String rhs = sub[2];
        int numberOne, numberTwo;
        if(isRoman(lhs) && isRoman(rhs)) {
            numberOne = toArab(lhs);
            numberTwo = toArab(rhs);
            if((numberOne > 10 || numberOne < 1) || (numberTwo > 10 || numberTwo < 1))
                throw new RuntimeException("Error");
            result = String.format("%s %s %s = %s",
                    lhs, oper, rhs, romanNumbers[calculate(numberOne, numberTwo, oper) - 1]);
        } else if(isArab(lhs) && isArab(rhs)) {
            numberOne = Integer.parseInt(lhs);
            numberTwo = Integer.parseInt(rhs);
            if((numberOne > 10 || numberOne < 1) || (numberTwo > 10 || numberTwo < 1))
                throw new RuntimeException("Error");
            result = String.format("%s %s %s = %d", lhs, oper, rhs,
                    calculate(numberOne, numberTwo, oper));
        } else {
            throw new RuntimeException("Error");
        }
        System.out.println(result);
    }
    public static int calculate(int lhs, int rhs, String oper) {
        int result = 0;
        switch(oper) {
            case "+": result = lhs + rhs;
                break;
            case "-": result = lhs - rhs;
                break;
            case "*": result = lhs * rhs;
                break;
            case "/": result = lhs / rhs;
                break;
            case "%": result = lhs % rhs;
                break;
            default:
                throw new RuntimeException("Error");
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        program(s);
    }
}
