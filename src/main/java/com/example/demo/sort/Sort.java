package com.example.demo.sort;


import java.util.Arrays;

public class Sort {

    public static void main(String[] args) {
        int[] arr = {1, 10, 9, 4, 6, 2, 8};
//        bubbleSort(arr);
//        selectSort(arr);
//        quicklySort(arr, 0, 6);
//        Arrays.stream(arr).forEach(System.out::print);



    }

    //冒泡排序
    public static void bubbleSort(int[] arr) {
        //外层循环n-1
        //内层循环n-i-1
        for (int n = 0; n < arr.length - 1; n++) {
            boolean isSort = true;
            for (int i = 0; i < arr.length - n - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    isSort = false;
                }
            }
            if (isSort) {
                break;
            }
        }

        for (int m = 0; m < arr.length; m++) {
            System.out.print(arr[m] + " ");
        }
    }

    //选择排序
    public static void selectSort(int[] arr) {
        //首先确定循环次数，并且记住当前数字和当前位置。
        for (int i = 0; i < arr.length - 1; i++) {
            //假设 temp为最小值下标
            int temp = i;
            //每一轮开始先和那个元素开始比较 i+1
            for (int j = i + 1; j < arr.length; j++) {
                //记下目前找到的最小值所在的位置
                if (arr[j] < arr[temp]) {
                    temp = j;
                }
            }
            //在内层循环结束，也就是找到本轮循环的最小的数以后，再进行交换
            if (i != temp) {
                int n = arr[i];
                arr[i] = arr[temp];
                arr[temp] = n;
            }
        }
    }

    //快速排序
    public static void quicklySort(int[] arr, int first, int last) {

        //递归出口
        if (first > last) {
            return;
        }

        //左侧数据下标
        int left = first;
        //
        int right = last;
        //基准值
        int middle = arr[first];

        while (left < right) {
            //先和右侧数据比较
            while (middle <= arr[right] && left < right) {
                right--;
            }
            //
            while (middle >= arr[left] && left < right) {
                left++;
            }

            //交换左右侧数据位置
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
        }

        //如果左右侧数据下标相等，与基准值下标交换
        if (left == right) {
            arr[first] = arr[left];
            arr[left] = middle;

        }

        //递归与左侧、右侧数据比较
        quicklySort(arr, first, left - 1);
        quicklySort(arr, left + 1, last);
    }


}
