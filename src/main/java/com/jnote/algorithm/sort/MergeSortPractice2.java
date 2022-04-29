package com.jnote.algorithm.sort;

import java.util.Arrays;

/**
 * @author bobwang
 */
public class MergeSortPractice2 {


    public static void sort(int[] nums) {

        int length = nums.length;
        int[] temp = new int[nums.length];
        mergeSort(nums, 0, length - 1, temp);
    }

    private static void mergeSort(int[] nums, int start, int end, int[] temp) {

        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(nums, start, mid, temp);
        mergeSort(nums, mid + 1, end, temp);
        merge(nums, start, mid, end, temp);

    }

    private static void merge(int[] nums, int start, int mid, int end, int[] temp) {
        int left = start;
        int right = mid + 1;
        int index = 0;
        while (left <= mid && right <= end) {
            if (nums[left] < nums[right]) {
                temp[index++] = nums[left++];
            } else {
                temp[index++] = nums[right++];
            }
        }

        while (left <= mid) {
            temp[index++] = nums[left++];
        }

        while (right <= end) {
            temp[index++] = nums[right++];
        }
        int s = start;
        for (int i = 0; i <= end - start; i++) {
            nums[s++] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = {31, 6, 78, 4553, 788, 3, 5};
        MergeSortPractice2.sort(nums);
        Arrays.stream(nums).forEach(i -> {
            System.out.println(i);
        });
    }

}
