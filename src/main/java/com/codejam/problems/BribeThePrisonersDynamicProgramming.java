package com.codejam.problems;

import java.util.*;

public class BribeThePrisonersDynamicProgramming {
    static HashMap<String, Integer> memory = new HashMap<>();
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int noOfTestCases = in.nextInt();
        int totalGoldCoins;
        for (int tcidx = 0; tcidx<noOfTestCases; tcidx++) {
            int noOfCells = in.nextInt();
            int noOfPrisonerRelease = in.nextInt();
            int prisonerReleaseNumber[] = new int[noOfPrisonerRelease];
            for (int i = 0; i < noOfPrisonerRelease; i++) {
                prisonerReleaseNumber[i] = in.nextInt();
            }
            totalGoldCoins = solveBribeCost(0, noOfCells, prisonerReleaseNumber);
            System.out.printf("Case #%d: %d\n",  tcidx+1, totalGoldCoins);
        }
    }

    public static int solveBribeCost(int leftBorder, int rightBorder, int[] prisonerReleaseNumber) {
        String memoryKey = leftBorder + "-" + rightBorder + ":" + Arrays.toString(prisonerReleaseNumber);
        if (memory.containsKey(memoryKey)) {
            return memory.get(memoryKey);
        }
        int numCells = rightBorder - leftBorder;

        if (prisonerReleaseNumber.length==1) {
            return numCells-1;
        }

        if (prisonerReleaseNumber.length==0) {
            return 0;
        }

        int bribeCost = Integer.MAX_VALUE;

        for (int i=0; i<prisonerReleaseNumber.length;i++) {
            int[] leftReleases = Arrays.copyOfRange(prisonerReleaseNumber,0, i);
            int[] rightReleases = Arrays.copyOfRange(prisonerReleaseNumber,i+1, prisonerReleaseNumber.length);
            int currentCost = (numCells-1) + solveBribeCost(leftBorder, prisonerReleaseNumber[i]-1, leftReleases)
                                + solveBribeCost(prisonerReleaseNumber[i], rightBorder, rightReleases);
            bribeCost = currentCost < bribeCost? currentCost : bribeCost;
        }
        memory.put(memoryKey, bribeCost);
        return bribeCost;
    }

}
