package com.jnote.algorithm.sort;

import java.util.Arrays;

public class ShellSorting {


    public static void sort(int[] nums) {
        int j;
        for (int gap = nums.length; gap > 0; gap = gap / 2) {
            for (int i = gap; i < nums.length; i++) {
                int tmp = nums[i];
                for (j = i; j >= gap && tmp < nums[j - gap]; j -= gap) {
                    nums[j] = nums[j - gap];
                }
                nums[j] = tmp;
            }

        }
    }


    public static void sort2(int[] nums) {

        int j;
        for (int gap = nums.length; gap > 0; gap = gap / 2) {
            for (int i = gap; i < nums.length; i++) {
                int temp = nums[i];
                for (j = i; j >= gap && temp > nums[j - gap]; j -= gap) {
                    nums[j] = nums[j - gap];
                }
                nums[j] = temp;
            }
        }
    }


    public static void sort3(int[] nums) {
        int j;
        for (int gap = nums.length; gap > 0; gap = gap / 2) {

            for (int i = gap; i < nums.length; i++) {
                int temp = nums[i];
                for (j = i; j >= gap && nums[j] > nums[j - gap]; j = j - gap) {
                    nums[j] = nums[j - gap];
                }
                nums[j] = temp;
            }
        }

    }

    public static void main(String[] args) {
        int[] nums = {31, 6, 78, 4553, 788, 3, 5};
        sort3(nums);
        Arrays.stream(nums).forEach(i -> {
            System.out.println(i);
        });
    }
}
