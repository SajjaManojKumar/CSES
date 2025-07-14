package com.manojkumarsajja.learn.GraphAlgorithms;
// Problem: https://cses.fi/problemset/task/1693

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class TeleportersPath {
    private static final String IMP = "IMPOSSIBLE";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        ArrayList<Integer>[] adjList = new ArrayList[n];
        int[] inDegree = new int[n];
        int[] outDegree = new int[n];

        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            String[] ab = br.readLine().split(" ");
            int a = Integer.parseInt(ab[0]) - 1;
            int b = Integer.parseInt(ab[1]) - 1;

            adjList[a].add(b);
            inDegree[b]++;
            outDegree[a]++;
        }

        String path = findPath(n, m, adjList, inDegree, outDegree);
        System.out.println(path);

        br.close();
    }

    private static String findPath(int n, int m, ArrayList<Integer>[] adjList, int[] inDegree, int[] outDegree) {
        for (int i = 1; i < n - 1; i++) {
            if (inDegree[i] != outDegree[i])
                return IMP;
        }
        if (outDegree[0] != inDegree[0] + 1 || inDegree[n - 1] != outDegree[n - 1] + 1) {
            return IMP;
        }

        List<Integer> path = new ArrayList<>();

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        while (!stack.isEmpty()) {
            int top = stack.peek();

            if (adjList[top].isEmpty()) {
                path.add(top + 1);
                stack.pop();
            } else {
                int lastIdx = adjList[top].size() - 1;
                int next = adjList[top].remove(lastIdx);
                stack.push(next);
            }
        }

        if (path.size() != m + 1) {
            return IMP;
        }

        Collections.reverse(path);
        StringBuilder sb = new StringBuilder();

        for (int node : path) {
            sb.append(node);
            sb.append(" ");
        }

        return sb.toString();
    }
}
