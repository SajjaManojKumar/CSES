package com.manojkumarsajja.learn.SortingAndSearching;
// Problem: https://cses.fi/problemset/task/1090

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FerrisWheel {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nx = br.readLine().split(" ");
        int n = Integer.parseInt(nx[0]);
        long x = Long.parseLong(nx[1]);

        List<Long> weights = new ArrayList<>(n);
        String[] Weights = br.readLine().split(" ");

        for (String Weight : Weights) {
            weights.add(Long.parseLong(Weight));
        }
        System.out.println(rideTheWheel(x, weights));

        br.close();
    }

    private static int rideTheWheel(long x, List<Long> weights) {
        Collections.sort(weights);
        int i = 0, j = weights.size() - 1;
        int cars = 0;

        while (i < j) {
            if (weights.get(i) + weights.get(j) <= x) {
                i++;
            }
            cars++;
            j--;
        }

        if (i == j) {
            cars++;
        }

        return cars;
    }
}
