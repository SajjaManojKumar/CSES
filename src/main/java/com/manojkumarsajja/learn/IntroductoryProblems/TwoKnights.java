package com.manojkumarsajja.learn.IntroductoryProblems;
// Problem: https://cses.fi/problemset/task/1072

import java.util.Scanner;

public class TwoKnights {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        twoKnights(n);

        in.close();
    }

    private static void twoKnights(int n) {
        for(long i=1L; i<=n; i++) {
            long ans = (i * i * (i * i - 1)/2) - (4L * (i - 1) * (i - 2));
            System.out.println(ans);
        }
    }
}
