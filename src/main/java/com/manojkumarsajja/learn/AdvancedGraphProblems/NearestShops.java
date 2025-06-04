package com.manojkumarsajja.learn.AdvancedGraphProblems;
// Problem: https://cses.fi/problemset/task/3303

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NearestShops {
    private static final int MOD = 1000000007;
    private static final int NO_COLOUR = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nmk = br.readLine().split(" ");
        int n = Integer.parseInt(nmk[0]);
        int m = Integer.parseInt(nmk[1]);
        int k = Integer.parseInt(nmk[2]);

        int[] colour = new int[n + 1];
        Arrays.fill(colour, NO_COLOUR);
        int[] distFromShop = new int[n + 1];
        Arrays.fill(distFromShop, MOD);
        int[] distFromNextShop = new int[n + 1];
        Arrays.fill(distFromNextShop, MOD);
        boolean[] isShop = new boolean[n + 1];

        String[] shopes_str = br.readLine().split(" ");
        for (String Shop : shopes_str) {
            int shop = Integer.parseInt(Shop);
            colour[shop] = shop;
            distFromShop[shop] = 0;
            isShop[shop] = true;
        }

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            String[] uv = br.readLine().split(" ");
            int u = Integer.parseInt(uv[0]);
            int v = Integer.parseInt(uv[1]);
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        nearestShops(n, m, k,
                adjList, colour,
                distFromShop,
                distFromNextShop,
                isShop);

        br.close();
    }

    private static void nearestShops(int n, int m, int k,
                                     List<List<Integer>> city,
                                     int[] colour,
                                     int[] distFromShop,
                                     int[] distFromNextShop,
                                     boolean[] isShop) {
        Queue<Integer> bfs = new LinkedList<>();
        for (int i = 1; i < n; i++) {
            if (isShop[i])
                bfs.add(i);
        }

        while (!bfs.isEmpty()) {
            int curCity = bfs.remove();
            for (int nbrCity : city.get(curCity)) {
                if (colour[curCity] == colour[nbrCity])
                    continue;
                if (colour[nbrCity] == NO_COLOUR) {
                    colour[nbrCity] = colour[curCity];
                    distFromShop[nbrCity] = 1 + distFromShop[curCity];
                    bfs.add(nbrCity);
                } else {
                    int newDist = 1 + distFromShop[nbrCity] + distFromShop[curCity];
                    int curCityColour = colour[curCity];
                    int nbrCityColour = colour[nbrCity];
                    distFromNextShop[curCityColour] = Math.min(
                            newDist, distFromNextShop[curCityColour]
                    );
                    distFromNextShop[nbrCityColour] = Math.min(
                            newDist, distFromNextShop[nbrCityColour]
                    );
                }
            }
        }

        StringBuilder res = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int dist;
            if (isShop[i]) {
                dist = distFromNextShop[i] == MOD ? -1 : distFromNextShop[i];
            } else {
                dist = distFromShop[i] == MOD ? -1 : distFromShop[i];
            }
            res.append(dist).append(" ");
        }
        System.out.println(res.toString());
    }
}
