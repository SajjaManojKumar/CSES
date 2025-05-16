package com.manojkumarsajja.learn.IntroductoryProblems;
// Problem: https://cses.fi/problemset/task/1070

import java.util.Scanner;

public class Permutations {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        permutations_optimised_for_submission(n);

        in.close();
    }

    private static void permutations(int n) {
        if(n == 2 || n == 3) {
            System.out.println("NO SOLUTION");
            return;
        }

        for (int i = 2; i <= n; i += 2) {
            System.out.print(i+" ");
        }
        for (int i = 1; i <= n; i += 2) {
            System.out.print(i+" ");
        }

        System.out.println();
    }

    private static void permutations_optimised_for_submission(int n) {
        // Note: Use of System.out.print will cause TLE as it will increase in time consumption.
        // Hence append all the values into StringBuilder and print it all at once.
        if(n == 2 || n == 3) {
            System.out.println("NO SOLUTION");
            return;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 2; i <= n; i += 2) {
            sb.append(i).append(" ");
        }
        for (int i = 1; i <= n; i += 2) {
            sb.append(i).append(" ");
        }

        System.out.println(sb.toString());
    }
}