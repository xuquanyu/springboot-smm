package com.example.demo.sort;


import java.util.*;

public class Sort {

    public static void main(String[] args) {
        int[] arr = {1, 1, 3, 4, 6, 9, 12, 18};

        System.out.println(binarySearch(arr, 18));
//        System.out.println(getArrIndex(arr, 9));
//        getODD(arr);
//        bubbleSort(arr);
//        selectSort(arr);
//        quicklySort(arr, 0, 6);
//        Arrays.stream(arr).forEach(System.out::print);
//        System.out.println(stringIsDC("dccd"));
//        System.out.println(stringIsDCV2("dccd"));\
//        int[] arr = {1, 10, 10, 4, 8, 8, 8};
//        getEqualsCount(arr);
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(2);
//        list.add(4);
//        getEqualsCount(list);
//        String[] arr = {"i", "h", "H", "s", "s"};
//        System.out.println(getCount("s", arr));
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

    //字符对称 利用StringBuffer.reverse()方法实现字符串反转
    public static boolean stringIsDC(String string) {
        String a = string.substring(0, string.length() / 2);
        String b = string.substring(string.length() / 2);
        String str = new StringBuffer(b).reverse().toString();
        if (a.equals(str)) {
            return true;
        }
        return false;
    }

    //分割字符串为字符串数组，遍历数组，将数组前半部分跟后半部分作比较，相等 return ture,反之false
    public static boolean stringIsDCV2(String string) {
        String[] str = string.split("");
        for (int i = 0; i < (str.length - 1) / 2; i++) {
            if (str[i].equals(str[str.length - i - 1])) {
                return true;
            }
        }
        return false;
    }

    //获取相同元素在数组中出现的次数
    public static void getEqualsCount(int[] arr) {
        Map<Object, Integer> map = new HashMap<>(16);
        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i]) != null) {
                //如果相同录次数
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                //
                map.put(arr[i], 1);
            }
        }

        for (Map.Entry<Object, Integer> m : map.entrySet()) {
            System.out.println(m.getKey() + "共出现" + m.getValue() + "次");
        }
    }

    //获取相同元素在List中出现的次数
    public static void getEqualsCount(List<Integer> list) {
        Map<Object, Integer> map = new HashMap<>(16);
        for (Integer s : list) {
            if (map.get(s) != null) {
                //如果相同录次数
                map.put(s, map.get(s) + 1);
            } else {
                //
                map.put(s, 1);
            }
        }

        for (Map.Entry<Object, Integer> m : map.entrySet()) {
            System.out.println(m.getKey() + "共出现" + m.getValue() + "次");
        }
    }

    //统计指定元素在array,list中出现的次数
    public static int getCount(String s, String[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (s.equals(arr[i])) {
                count++;
                continue;
            }
        }
        return count;
    }

    //检索出(查询)数组中的奇数元素
    public static void getODD(int[] arr) {
//        Map<Object, Integer> map = new HashMap<>(16);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
               continue;
            }
            list.add(arr[i]);
//            if (map.get(arr[i]) != null) {
//                map.put(arr[i], map.get(arr[i]) + 1);
//            }else{
//                map.put(arr[i], 1);
//            }
        }
//        for (Map.Entry<Object, Integer> m : map.entrySet()) {
//            System.out.println(m.getKey() + "共出现" + m.getValue() + "次");
//        }
        list.stream().forEach(System.out::println);
    }

    //检索出指定元素在数组中的元素下标
    public static String  getArrIndex(int[] arr,int n){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == n) {
                sb =sb.append("下标"+i);
                continue;
            }
        }
        return sb.toString();
    }

    //二分查找（寻找一个数）
    //搜索一个数，如果存在，返回其索引，否则返回 -1。
//    public static int binarySearch(int[] arr, int target) {
//        int left = 0;
//        int right = arr.length - 1;
//        while (left <= right) {
//            int mid = (right + left) / 2;
//            if (arr[mid] == target) {
//                return mid;
//            } else if (arr[mid] < target) {
//                left = mid +1;
//            } else if (arr[mid] > target) {
//                right = mid - 1;
//            }
//        }
//        return -1;
//    }

    public static int binarySearch(int[] arr, int target) {
        //左侧下标
        int left = 0;
        //最后一个元素的索引
        int right = arr.length-1;
        while (left <= right) {
            //每次找不到（猜不中后更新的中间值[预想值下标]）
//            int mid = (left + right) / 2;
            //防止溢出
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else if (arr[mid] > target) {
                right = mid - 1;
            }
        }

        return -1;
    }
}
