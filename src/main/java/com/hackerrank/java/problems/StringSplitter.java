package com.hackerrank.java.problems;
import java.util.*;
import java.io.*;

public class StringSplitter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        // Write your code here.
        if (s.length()==0) {
            System.out.println("0");
            return;
        }
        if (s.length() > 400000) {
            return;
        }
        String tokens[] = s.split("[ !,?._'@]+");
        System.out.println(tokens.length);
        for (int i=0; i<tokens.length; i++) {
            System.out.println(tokens[i].trim());
        }
        scan.close();
    }
}
