package com.manojkumarsajja.learn.SortingAndSearching;
// Problem: https://cses.fi/problemset/task/1084

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Apartments {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nmk = br.readLine().split(" ");
        int n = Integer.parseInt(nmk[0]);
        int m = Integer.parseInt(nmk[1]);
        long k = Long.parseLong(nmk[2]);

        List<Long> applicants = new ArrayList<>(n);
        String[] Applicants = br.readLine().split(" ");
        List<Long> apartments = new ArrayList<>(m);
        String[] Apartments = br.readLine().split(" ");

        for (String Applicant : Applicants) {
            applicants.add(Long.parseLong(Applicant));
        }
        for (String Apartment : Apartments) {
            apartments.add(Long.parseLong(Apartment));
        }
        System.out.println(alotApartment(k, applicants, apartments));

        br.close();
    }

    private static int alotApartment(long k, List<Long> applicants, List<Long> apartments) {
        Collections.sort(applicants);
        Collections.sort(apartments);

        int i = 0, j = 0;
        int alot = 0;

        while (i < applicants.size() && j < apartments.size()) {
            if (apartments.get(j) <= applicants.get(i) + k
                    && apartments.get(j) >= applicants.get(i) - k) {
                alot++;
                i++;
                j++;
            } else if (apartments.get(j) < applicants.get(i) - k) {
                j++;
            } else {
                i++;
            }
        }

        return alot;
    }
}
