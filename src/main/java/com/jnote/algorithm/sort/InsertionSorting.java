package com.jnote.algorithm.sort;

import java.util.Arrays;

/**
 * @author bobwang
 */
public class InsertionSorting {

    public static void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] > nums[j - 1]) {
                    swap(nums, j, j - 1);
                }
            }
        }
    }

    private static void swap(int[] nums, int j, int i) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    public static void main(String[] args) {
        int [] nums = {31,6,78,4553,788,3,5};
        sort(nums);
        Arrays.stream(nums).forEach(i->{
            System.out.println(i);
        });
    }
}
