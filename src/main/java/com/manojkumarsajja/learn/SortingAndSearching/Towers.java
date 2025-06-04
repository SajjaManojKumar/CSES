package com.manojkumarsajja.learn.SortingAndSearching;
// Problem: https://cses.fi/problemset/task/1073

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Towers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] Blocks = br.readLine().split(" ");
        ArrayList<Long> blocks = new ArrayList<>(n);

        for (String Block : Blocks) {
            blocks.add(Long.parseLong(Block));
        }

        System.out.println(countTheTowers(n, blocks));
        br.close();
    }

    private static int countTheTowers(int n, ArrayList<Long> blocks) {
        ArrayList<Long> towers = new ArrayList<>();

        for (long block : blocks) {
            Integer pos = binarySearch(towers, block);
            if (pos == null)
                towers.add(block);
            else
                towers.set(pos, block);
        }

        return towers.size();
    }

    private static Integer binarySearch(ArrayList<Long> space, long lowerBound) {
        if (space.isEmpty())
            return null;

        int l = 0, h = space.size() - 1;

        while (l <= h) {
            int m = l + (h - l) / 2;

            if (space.get(m) > lowerBound) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l < space.size() ? l : null;
    }
}