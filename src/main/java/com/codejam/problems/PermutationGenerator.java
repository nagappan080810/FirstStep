package com.codejam.problems;

import java.util.*;

public class PermutationGenerator {
    public static String[] combinations;
    public static void main(String args[]) {

        String inputStrs[] = {"a","b","c", "d", "e"};
        String possibleStr[] = null;
        int possibleStrPos;
        for (int i=0;i<inputStrs.length;i++){
            //initialize a possible way data structure
            possibleStrPos = 0;
            possibleStr = new String[inputStrs.length];
            //set the values...
            possibleStr[possibleStrPos] = inputStrs[i];
            List<String> subInputArrs = new ArrayList<String>(Arrays.asList(inputStrs));
            subInputArrs.remove(inputStrs[i]);
            possibleWay(subInputArrs, possibleStrPos+1, Arrays.asList(possibleStr));
            //System.out.println(Arrays.toString(possibleStr));
        }
    }

    public static void possibleWay(List<String> subInputArrs, int pos, List<String> possibleStrs) {
        if (pos == possibleStrs.size()) {
            System.out.println(possibleStrs);
            return;
        }
        for (int i=0; i<subInputArrs.size(); i++) {
            possibleStrs.set(pos, subInputArrs.get(i));
            List<String> copyOfSubInputArrs = new ArrayList<>(subInputArrs);
            copyOfSubInputArrs.remove(subInputArrs.get(i));
            possibleWay(copyOfSubInputArrs,pos+1, possibleStrs);
        }
    }
}
