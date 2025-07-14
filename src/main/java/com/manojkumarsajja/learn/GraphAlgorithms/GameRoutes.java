package com.manojkumarsajja.learn.GraphAlgorithms;
// Problem: https://cses.fi/problemset/task/1681

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GameRoutes {
    private static final long MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        ArrayList<Integer>[] adjList = new ArrayList[n];
        int[] inDegree = new int[n];

        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            String[] ab = br.readLine().split(" ");
            int a = Integer.parseInt(ab[0]) - 1;
            int b = Integer.parseInt(ab[1]) - 1;

            adjList[a].add(b);
            inDegree[b]++;
        }

        System.out.println(getNumberOfWaysToReachEnd(n, adjList, inDegree));

        br.close();
    }

    private static long getNumberOfWaysToReachEnd(int n, ArrayList<Integer>[] adjList, int[] inDegree) {
        long[] noOfWays = new long[n];
        noOfWays[0] = 1L;

        Queue<Integer> bfs = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0)
                bfs.offer(i);
        }

        while (!bfs.isEmpty()) {
            int root = bfs.poll();
            long rootWays = noOfWays[root];

            for (int child : adjList[root]) {
                noOfWays[child] = (noOfWays[child] + rootWays) % MOD;
                inDegree[child]--;
                if (inDegree[child] == 0) {
                    bfs.add(child);
                }
            }
        }

        return noOfWays[n - 1];
    }
}

