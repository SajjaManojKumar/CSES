package com.manojkumarsajja.learn.IntroductoryProblems;
// Problem: https://cses.fi/problemset/task/1083

import java.util.Scanner;

public class MissingNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n-1];

        for(int i=0; i<n-1; i++) {
            arr[i] = in.nextInt();
        }

        System.out.println(missingNumber(arr, n));

        in.close();
    }

    private static int missingNumber(int[] nums, int n) {
        int xorVal = 0;

        for(int i=1; i<=n; i++) {
            xorVal ^= i;
        }
        for(int num : nums) {
            xorVal ^= num;
        }

        return xorVal;
    }
}
