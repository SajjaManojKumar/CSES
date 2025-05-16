package com.manojkumarsajja.learn.IntroductoryProblems;
// Problem: https://cses.fi/problemset/task/1071

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberSpiral {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();
        while(t-- > 0) {
            String[] yx = br.readLine().split(" ");
            result.append(numberSpiral(yx)).append("\n");
        }
        System.out.println(result.toString());
    }

    private static long numberSpiral(String[] yx) {
        long y = Long.parseLong(yx[0]);
        long x = Long.parseLong(yx[1]);

        if(y > x) {
            if(y%2 != 0) {
                return ((y-1) * (y-1)) + x;
            } else {
                return ((y-1) * (y-1)) + (2*y - x);
            }
        } else {
            if(x%2 != 0) {
                return ((x-1) * (x-1)) + (2*x - y);
            } else {
                return ((x-1) * (x-1)) + y;
            }
        }
    }
}