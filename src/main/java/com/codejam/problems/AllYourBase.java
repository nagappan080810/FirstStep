package com.codejam.problems;

import java.util.HashMap;

public class AllYourBase {
    public static void main(String[] args) {
        System.out.println("Hello World");
        StringBuffer str = new StringBuffer("cats");
        int base = str.length();
        int numbers[] = new int[base];
        int availableNumber = 1;
        HashMap<Character,Integer> charValue = new HashMap<>();
        double result = 0;
        for (int i=0; i<str.length(); i++) {
            Character ch = str.charAt(i);
            if (i==1) {
                charValue.put(ch, 0);
            }
            if (charValue.get(ch)==null) {
                charValue.put(ch, availableNumber++);
            }
            numbers[i] = charValue.get(ch);
            result = result + calculate(numbers[i], base, base-i-1);
        }
        System.out.println(result);
    }

    public static double calculate(int number, int base, int power) {
        Double calnum = Math.pow(base,power);
        return number * calnum;
    }
}
