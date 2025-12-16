package com.wd;

import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        int[] a = new int[]{6, 78, 9, 4, 63, 48, 2, 56, 74, 36, 45, 1, 6};
        quickSort1(a, 0, a.length - 1);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    //默认第一个为基准数
    public static void quickSort(int[] a, int left, int right) {
        if (a == null || a.length < 2 || left >= right) {
            return;
        }
        int temp = 0;
        int l = left;
        int r = right;
        boolean flag = true;
        temp = a[left];
        while (l < r) {
            if (flag) {
                if (temp <= a[r]) {
                    r--;
                    continue;
                }
                a[l] = a[r];
                l++;
                flag = false;
            } else {
                if (temp >= a[l]) {
                    l++;
                    continue;
                }
                a[r] = a[l];
                r--;
                flag = true;
            }
        }
        a[l] = temp;
        quickSort(a, left, r - 1);
        quickSort(a, l + 1, right);
    }

    //随机选取基准数
    public static void quickSort1(int[] a, int left, int right) {
//		if(a==null || a.length<2 || left>=right){
//			return;
//		}
        int temp = 0;
        int l = left;
        int r = right;
        //boolean flag=true;
        int pivot = new Random().nextInt(right - left) + left;
        int base = a[pivot] + a[l];
        a[l] = base - a[l];
        a[pivot] = base - a[l];
        base = a[l];
        while (l < r) {
            while (base <= a[r] && l < r) {
                r--;
            }
            while (base >= a[l] && l < r) {
                l++;
            }
            if (l < r) {
                temp = a[l];
                a[l] = a[r];
                a[r] = temp;
            }
        }
        a[l] = base + a[l];

        //return l;
    }
}
