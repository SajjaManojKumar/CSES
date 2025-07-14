package com.manojkumarsajja.learn.SortingAndSearching;
// Problem: https://cses.fi/problemset/task/1630

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TasksAndDeadlines {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] tasks = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] ab = br.readLine().split(" ");
            tasks[i][0] = Integer.parseInt(ab[0]);
            tasks[i][1] = Integer.parseInt(ab[1]);
        }
        System.out.println(calculateRewards(tasks));

        br.close();
    }

    private static long calculateRewards(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> ((a[0] - b[0]) != 0 ? (a[0] - b[0]) : (a[1] - b[1])));

        long currTime = 0;
        long reward = 0;

        for (int[] task : tasks) {
            currTime += task[0];
            reward += (task[1] - currTime);
        }

        return reward;
    }
}
