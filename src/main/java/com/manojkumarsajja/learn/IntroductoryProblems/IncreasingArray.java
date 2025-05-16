package com.manojkumarsajja.learn.IntroductoryProblems;
// Problem: https://cses.fi/problemset/task/1094

import java.util.Arrays;
import java.util.Scanner;

public class IncreasingArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(increasingArray(n, arr));

        in.close();
    }

    private static long increasingArray(int n, int[] arr) {
        long count = 0;

        for(int i=1; i<n; i++) {
            if(arr[i] < arr[i-1]) {
                count += (arr[i-1] - arr[i]);
                arr[i] = arr[i-1];
            }
        }

        return count;
    }
}
