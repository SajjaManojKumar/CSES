package com.manojkumarsajja.learn.IntroductoryProblems;
// Problem: https://cses.fi/problemset/task/1069

import java.util.Scanner;

public class Repetitions {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String str = in.next();
        System.out.println(repetitions(str.toCharArray()));

        in.close();
    }

    private static int repetitions(char[] str) {
        int maxCount = 1;
        int currCount = 1;
        int n = str.length;

        for(int i=1; i<n; i++) {
            if(str[i] == str[i-1]) {
                currCount++;
                maxCount = Math.max(maxCount, currCount);
            } else {
                currCount = 1;
            }
        }

        return maxCount;
    }
}
