package com.manojkumarsajja.learn.GraphAlgorithms;
// Problem: https://cses.fi/problemset/task/1676

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RoadConstruction {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        StringBuilder sb = new StringBuilder();

        UnionFind uf = new UnionFind(n);

        for (int i = 0; i < m; i++) {
            String[] ab = br.readLine().split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);

            uf.union(a, b);
            sb.append(uf.getComponents()).append(" ").append(uf.getMaxRank()).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static class UnionFind {
        int[] parent;
        int[] rank;
        int maxRank;
        int components;

        UnionFind(int n) {
            parent = new int[n + 1];
            rank = new int[n + 1];

            for (int i = 0; i <= n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }

            maxRank = 1;
            components = n;
        }

        public int find(int u) {
            if (parent[u] != u) {
                parent[u] = find(parent[u]);
            }

            return parent[u];
        }

        public void union(int u, int v) {
            int parent_u = find(u);
            int parent_v = find(v);

            if (parent_u == parent_v) {
                return;
            }

            if (rank[parent_u] > rank[parent_v]) {
                parent[parent_v] = parent_u;
                rank[parent_u] += rank[parent_v];
                maxRank = Math.max(maxRank, rank[parent_u]);
            } else {
                parent[parent_u] = parent_v;
                rank[parent_v] += rank[parent_u];
                maxRank = Math.max(maxRank, rank[parent_v]);
            }
            this.components--;
        }

        public int getMaxRank() {
            return this.maxRank;
        }

        public int getComponents() {
            return this.components;
        }
    }
}
