package com.manojkumarsajja.learn.SortingAndSearching;
// Problem: https://cses.fi/problemset/task/3421

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DistinctValuesSubsequences {
    private static final int MAX = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] arrStr = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(arrStr[i]);
        }
        Arrays.sort(arr);

        distinctValuesSubsequences(n, arr);
        br.close();
    }

    private static void distinctValuesSubsequences(int n, int[] arr) {
        long[] dp = new long[n];
        long dpSum = 0;

        for (int i = 0; i < n; i++) {
            if (i <= 1) {
                dp[0] = 2L;
                if (arr[0] == arr[1]) {
                    dp[1] = 1L;
                } else {
                    dp[1] = dpSum;
                }
            } else {
                if (arr[i] == arr[i - 1]) {
                    dp[i] = dp[i - 1];
                } else {
                    dp[i] = dpSum;
                }
            }
            dpSum = (dpSum + dp[i]) % MAX;
        }

        System.out.println(dpSum - 1);
    }
}
