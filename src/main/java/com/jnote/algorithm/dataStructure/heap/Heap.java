package com.jnote.algorithm.dataStructure.heap;

public class Heap {
    private int[] a;
    private int n;
    private int count;

    public Heap(int capacitiy) {
        this.a = new int[capacitiy + 1];
        n = capacitiy;
        count = 0;
    }

    public void insert(int data) {
        if (count >= n) {
            return;
        }
        ++count;
        a[count] = data;
        int i = count;
        while (i / 2 > 0 && a[i] > a[i / 2]) {
            swap(a, i, i / 2);
            i = i / 2;
        }
    }

    private void swap(int[] a, int i, int i1) {
        int tmp = a[i];
        a[i] = a[i1];
        a[i1] = tmp;
    }

    public void removeMax() {
        if (count == 0) {
            return;
        }
        a[1] = a[count];
        --count;
        heapify(a, count, 1);
    }

    private void heapify(int[] a, int n, int i) {
        while (true) {
            int maxPos = i;
            if (i * 2 <= n && a[i] < a[i * 2]) {
                maxPos = i * 2;
            }
            if (i * 2 + 1 <= n && a[maxPos] < a[i * 2 + 1]) {
                maxPos = i * 2 + 1;
            }
            if (maxPos == i) {
                break;
            }
            swap(a, i, maxPos);
            i = maxPos;
        }
    }
}
