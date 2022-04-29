package com.jnote.algorithm.sort;

import java.util.Arrays;

public class MergeSort {


    public static void sort(int[] nums) {

        sort(nums, 0, nums.length - 1);

    }

    private static void sort(int[] nums, int start, int end) {

        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        sort(nums, start, mid);
        sort(nums, mid + 1, end);
        merge(nums, start, mid, end);
    }

    private static void merge(int[] nums, int start, int mid, int end) {
        int[] temps = new int[end - start + 1];
        int left = start;
        int right = mid + 1;
        int k = 0;

        while (left <= mid && right <= end) {
            if (nums[left] > nums[right]) {
                temps[k++] = nums[right++];
            } else {
                temps[k++] = nums[left++];
            }
        }

        while (left <= mid) {
            temps[k++] = nums[left++];
        }

        while (right <= end) {
            temps[k++] = nums[right++];
        }
        int i = 0;
        while (i < temps.length) {
            nums[start++] = temps[i++];
        }
    }

    public static void main(String[] args) {
        int[] nums = {31, 6, 78, 4553, 788, 3, 5};
        sort(nums);
        Arrays.stream(nums).forEach(i -> {
            System.out.println(i);
        });

    }
}
