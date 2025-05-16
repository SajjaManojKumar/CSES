package com.manojkumarsajja.learn.IntroductoryProblems;
// Problem: https://cses.fi/problemset/task/1092

import java.util.Scanner;

public class TwoSets {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        twoSets(n);

        in.close();
    }

    private static void twoSets(int n) {
        long tSum = (n * ((long) n + 1)) / 2;

        if(tSum % 2 != 0) {
            System.out.println("NO");
            return;
        }

        System.out.println("YES");
        StringBuilder s1 = new StringBuilder();
        int s1Len = 0;
        StringBuilder s2 = new StringBuilder();
        int s2Len = 0;
        boolean[] seen = new boolean[n+1];

        long s1Sum = 0;
        long maxVal = n;

        while(s1Sum < tSum / 2) {
            long reqSum = tSum/2 - s1Sum;

            if(reqSum > maxVal) {
                s1.append(maxVal).append(" ");
                s1Len++;
                seen[(int) maxVal] = true;
                s1Sum += maxVal;
                maxVal--;
            } else {
                s1.append(reqSum).append(" ");
                s1Len++;
                seen[(int) reqSum] = true;
                s1Sum = tSum / 2;
            }
        }

        for(int i=1; i <= n; i++) {
            if(!seen[i]) {
                s2.append(i).append(" ");
                s2Len++;
            }
        }

        System.out.println(s1Len);
        System.out.println(s1.toString());
        System.out.println(s2Len);
        System.out.println(s2.toString());
    }
}
