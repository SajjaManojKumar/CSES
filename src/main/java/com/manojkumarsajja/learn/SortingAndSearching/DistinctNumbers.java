package com.manojkumarsajja.learn.SortingAndSearching;
// Problem: https://cses.fi/problemset/task/1621

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class DistinctNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] Nums = br.readLine().split(" ");
        long[] nums = new long[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Long.parseLong(Nums[i]);
        }

        System.out.println(findNumberOfUniqueBySet(n, nums));

        br.close();
    }

    private static int findNumberOfUnique(int n, long[] nums) {
        Arrays.sort(nums);

        int distinct = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i - 1]) distinct++;
            else {
                while (i < n && nums[i] == nums[i - 1]) {
                    i++;
                }
                i--;
            }
        }
        return distinct;
    }

    private static int findNumberOfUniqueBySet(int n, long[] nums) {
        HashSet<Long> nums_set = new HashSet<>();

        for (long num : nums) {
            nums_set.add(num);
        }

        return nums_set.size();
    }
}
