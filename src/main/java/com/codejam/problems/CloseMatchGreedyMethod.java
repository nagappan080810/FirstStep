package com.codejam.problems;

import java.util.*;


public class CloseMatchGreedyMethod {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int numCases = in.nextInt();
        StringBuilder codersScores = new StringBuilder();
        StringBuilder jammersScores = new StringBuilder();
        for (int i=0; i<numCases; i++) {
            codersScores = new StringBuilder(in.next());
            jammersScores = new StringBuilder(in.next());
            optimizedScores(codersScores, jammersScores);
            System.out.printf("Case #%d: %s %s\n",(i+1), codersScores, jammersScores);
        }
    }

    static enum COMP {
        EQ, LT, GT;
    };
    public static void optimizedScores(StringBuilder codersScores, StringBuilder jammersScores) {


        for (int i=0; i<codersScores.length(); i++) {
            int codersPrefixScores = getPrefixNumber(codersScores, 0, i);
            int jammersPrefixScores = getPrefixNumber(jammersScores, 0, i);

            COMP prefix = null;
            if (codersPrefixScores==jammersPrefixScores) {
                prefix = COMP.EQ;
            }
            if (codersPrefixScores>jammersPrefixScores) {
                prefix = COMP.GT;
            }
            if (codersPrefixScores<jammersPrefixScores) {
                prefix = COMP.LT;
            }
            boolean isMiddleDigits = false;
            COMP suffix = null;
            if (i > 0 && i < (codersScores.length()-1)) {

                int codersSuffixScores = getPrefixNumber(codersScores, i+1, codersScores.length());
                int jammersSuffixScores = getPrefixNumber(jammersScores, i+1, jammersScores.length());
                if (codersSuffixScores==-1 && jammersSuffixScores==-1) {
                    isMiddleDigits= true;
                }
                if (codersSuffixScores == jammersSuffixScores) {
                    suffix = COMP.EQ;
                }
                if (codersSuffixScores > jammersSuffixScores) {
                    suffix = COMP.GT;
                }
                if (codersSuffixScores < jammersSuffixScores) {
                    suffix = COMP.LT;
                }
            }

            //set the coders questions mark...
            if (codersScores.charAt(i)=='?' && jammersScores.charAt(i)!='?') {
                if (prefix.equals(COMP.EQ)) {
                    codersScores.setCharAt(i, jammersScores.charAt(i));
                } else if (prefix.equals(COMP.GT) ) {
                    codersScores.setCharAt(i, '0');
                } else if (prefix.equals(COMP.LT)) {
                    codersScores.setCharAt(i, '9');
                }
                continue;
            }
            //set jammers questions mark..
            if (codersScores.charAt(i)!='?' && jammersScores.charAt(i)=='?') {
                if (prefix.equals(COMP.EQ)) {
                    if (isMiddleDigits && !suffix.equals(COMP.EQ)) {
                        jammersScores.setCharAt(i, '0');
                    } else {
                        jammersScores.setCharAt(i, codersScores.charAt(i));
                    }
                } else if (prefix.equals(COMP.GT) ) {
                    jammersScores.setCharAt(i, '9');
                } else if (prefix.equals(COMP.LT)) {
                    jammersScores.setCharAt(i, '0');
                }
                continue;
            }

            if (codersScores.charAt(i)=='?' && jammersScores.charAt(i)=='?') {
                if (prefix.equals(COMP.EQ)) {
                    codersScores.setCharAt(i, '0');
                    jammersScores.setCharAt(i, '0');
                } else if (prefix.equals(COMP.GT)) {
                    codersScores.setCharAt(i, '0');
                    jammersScores.setCharAt(i,'9');
                } else if (prefix.equals(COMP.LT)) {
                    codersScores.setCharAt(i, '9');
                    jammersScores.setCharAt(i, '0');
                }
            }
        }
    }

    public static Integer getPrefixNumber(StringBuilder str, int start, int end) {
        try {
            if (!str.substring(start, end).isEmpty()) {
                return Integer.parseInt(str.substring(start, end));
            }
        } catch (NumberFormatException exception) {
            //finally
            return -1;
        }
        return 0;
    }
}
