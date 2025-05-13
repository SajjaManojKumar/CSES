package com.manojkumarsajja.learn.IntroductoryProblems;
// Problem: https://cses.fi/problemset/task/1068

import java.util.Scanner;

public class WeirdAlgorithm {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = (long) in.nextInt();
        weirdAlgorithm(n);
        in.close();
    }

    private static void weirdAlgorithm(long n) {
        System.out.print(n + " ");
        while (n != 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = 3 * n + 1;
            }
            System.out.print(n + " ");
        }
    }
}
