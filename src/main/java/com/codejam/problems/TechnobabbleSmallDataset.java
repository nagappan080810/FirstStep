package com.codejam.problems;

import java.util.*;


public class TechnobabbleSmallDataset {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int noOfTestCases = in.nextInt();
        for (int tcNo=1; tcNo <= noOfTestCases; tcNo++) {
            int noOfWords = in.nextInt();
            String[][] topics = new String[noOfWords][2];
            Map<String, Boolean> firstWordIsDuplicateMap = new HashMap<>();
            Map<String, Boolean> secondWordIsDuplicateMap = new HashMap<>();
            for (int i = 0; i < noOfWords; i++) {
                topics[i][0] = in.next();
                checkAndUpdate(topics[i][0], firstWordIsDuplicateMap);
                topics[i][1] = in.next();
                checkAndUpdate(topics[i][1], secondWordIsDuplicateMap);
            }
            int count = 0;
            for (int i = 0; i < noOfWords; i++) {
                boolean isFirstWordDuplicate = firstWordIsDuplicateMap.get(topics[i][0]);
                boolean isSecondWordDuplicate = secondWordIsDuplicateMap.get(topics[i][1]);
                if (isFirstWordDuplicate && isSecondWordDuplicate) {
                    count++;
                }
            }
            System.out.printf("Case #%d: %d\n", tcNo, count);
        }
    }

    public static void checkAndUpdate(String topic, Map<String, Boolean> wordDuplicateMap) {
        if (wordDuplicateMap.get(topic)==null) {
            wordDuplicateMap.put(topic, false);
        } else {
            wordDuplicateMap.put(topic, true);
        }
    }
}
