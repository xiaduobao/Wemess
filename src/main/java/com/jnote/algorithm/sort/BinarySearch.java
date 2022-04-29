package com.jnote.algorithm.sort;

public class BinarySearch {
    public static int binarySearch(int[] nums, int value) {
        return binarySearch(nums, value, 0, nums.length - 1);

    }

    private static int binarySearch(int[] nums, int value, int low, int high) {
        if (low >= high) {
            return -1;
        }

        int mid = (low + high) / 2;
        if (nums[mid] > value) {
            return binarySearch(nums, value, 0, mid - 1);
        } else if (nums[mid] < value) {
            return binarySearch(nums, value, mid + 1, high);
        } else {
            return mid;
        }

    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 4, 5,6,8};
        System.out.println(binarySearch(nums, 5));
        System.out.println(binarySearch(nums, 9));
        System.out.println(binarySearch(nums, 2));
        System.out.println(binarySearch(nums, 8));
    }
}
