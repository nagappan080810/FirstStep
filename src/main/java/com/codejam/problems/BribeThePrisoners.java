package com.codejam.problems;
import java.util.*;

//this approach tries only one method...
public class BribeThePrisoners {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int noOfTestCases = in.nextInt();
        for (int tcidx = 0; tcidx<noOfTestCases; tcidx++) {
            int noOfCells = in.nextInt();
            int noOfPrisonerRelease = in.nextInt();
            int prisonerNumber[] = new int[noOfPrisonerRelease];
            for (int i = 0; i < noOfPrisonerRelease; i++) {
                prisonerNumber[i] = in.nextInt();
            }
            Set<Integer> prisonersRange = new TreeSet<>();
            prisonersRange.add(0);
            prisonersRange.add(noOfCells + 1);
            int totalGoldCoins = 0;
            for (int i = noOfPrisonerRelease - 1; i >= 0; i--) {
                prisonersRange.add(prisonerNumber[i]);
                totalGoldCoins += findGoldCoins(new LinkedList<>(prisonersRange), prisonerNumber[i]);
            }
            System.out.printf("Case #%d: %d\n",  tcidx+1, totalGoldCoins);
        }
    }
    public static int findGoldCoins(LinkedList<Integer> prisonersRange, int prisonerNumber) {
        int index = prisonersRange.indexOf(prisonerNumber);
        int totalCoins = prisonerNumber - prisonersRange.get(index-1)-1;
        totalCoins += prisonersRange.get(index+1) - prisonerNumber-1;
        return totalCoins;
    }
}
