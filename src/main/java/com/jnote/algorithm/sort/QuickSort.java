package com.jnote.algorithm.sort;

import java.util.Arrays;

public class QuickSort {


    public static void sort(int[] nums) {


        quickSort(nums, 0, nums.length - 1);
    }


    public static void quickSort(int[] nums, int low, int high) {
        if (high > low) {
            int split = partition(nums, low, high);
            quickSort(nums, low, split);
            quickSort(nums, split+1, high);
        }
    }

    private static int partition(int[] nums, int low, int high) {
        int p = nums[low];
        int start = low + 1;
        int end = high;
        while (end > start) {
            while (end > start && nums[start] <= p) {
                start++;
            }

            while (end > start && nums[end] > p) {
                end--;
            }
            if (end > start) {
                swap(nums, start, end);
                start++;
                end--;
            }
        }
        swap(nums, start-1, low);
        return start-1;

    }

    private static void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;

    }


    public static void main(String[] args) {
        int[] nums = {31, 6, 78, 4553, 788, 3, 5};
        QuickSort.sort(nums);
        Arrays.stream(nums).forEach(i -> {
            System.out.println(i);
        });
    }
}
