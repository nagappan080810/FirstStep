package com.codejam.problems;

import org.junit.Assert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CloseMatchLargeDataset {
    public static void main(String args[]) throws IOException{
        InputStream in = CloseMatchLargeDataset.class.getClassLoader().getResourceAsStream("CloseMatch-large-practice.in");
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String inputLine = br.readLine();
        int numOfCases = Integer.parseInt(inputLine);
        int caseNo = 0;

        while((inputLine = br.readLine())!=null) {
            caseNo++;
            String[] scores = inputLine.split(" ");
            List<String> possibleCodersScores = findPossibleScores(scores[0]);
            List<String> possibleJammersScores = findPossibleScores(scores[1]);
            Long diff, finalDiff =null;
            String finalCodersScore = "", finalJammersScore = "";
            for (String codersScore : possibleCodersScores) {
                for (String jammersScore : possibleJammersScores) {
                    diff = Math.abs(Long.parseLong(codersScore) - Long.parseLong(jammersScore));
                    if (finalDiff == null || diff < finalDiff) {
                        finalDiff = diff;
                        finalCodersScore = codersScore;
                        finalJammersScore = jammersScore;
                    }
                }
            }
            System.out.printf("Case #%d: %s %s\n",caseNo, finalCodersScore, finalJammersScore);
        }
    }

    public static List<String> findPossibleScores(String regexScore) {
        List<String> possibleScores = new ArrayList<>();
        int maxDigits = regexScore.length();
        //framing max number with those digits
        String maxNum = "1";
        for (int index=1; index<=maxDigits; index++) {
            maxNum += "0";
        }
        Long maxNumber = Long.parseLong(maxNum);
        for (long possibleValue = 0; possibleValue < maxNumber; possibleValue++) {
            //form the number
            String scoreStr = String.valueOf(possibleValue);
            String scorePrefix = "";
            for (int digitPos=0; digitPos<(maxDigits-scoreStr.length()); digitPos++) {
                scorePrefix = scorePrefix + "0";
            }
            scoreStr = scorePrefix + scoreStr;
            Assert.assertEquals("Number not formed properly",scoreStr.length(),maxDigits);
            //check the number
            boolean isMatching = true;
            for (int digitIndex=0; digitIndex < maxDigits ; digitIndex++) {
                if (regexScore.charAt(digitIndex)=='?') continue;
                if (regexScore.charAt(digitIndex)!=scoreStr.charAt(digitIndex)) {
                    isMatching = false;
                    break;
                }
            }
            if (isMatching) {
                possibleScores.add(scoreStr.toString());
            }
        }
        return possibleScores;
    }
}
