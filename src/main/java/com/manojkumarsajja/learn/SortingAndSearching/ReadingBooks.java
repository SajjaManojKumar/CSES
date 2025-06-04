package com.manojkumarsajja.learn.SortingAndSearching;
// Problem: https://cses.fi/problemset/task/1631

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ReadingBooks {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] books_str = br.readLine().split(" ");
        ArrayList<Long> books = new ArrayList<>();
        for (String book : books_str) {
            books.add(Long.parseLong(book));
        }

        System.out.println(getTotalTimeTaken(books));

        br.close();
    }

    private static long getTotalTimeTaken(ArrayList<Long> books) {
        long lrgBook = 0L;
        long totalTime = 0L;

        for (long book : books) {
            lrgBook = Math.max(lrgBook, book);
            totalTime += book;
        }

        totalTime -= lrgBook;

        return lrgBook + (Math.max(totalTime, lrgBook));
    }
}
