package com.second;


import edu.princeton.cs.algs4.Stopwatch;

//排序算法
public class Sort {
    public static void main(String[] args) {

        var num = 100000;
        var t = 10;
        var isShow = false;
        var sortWay = "Bubble,Insert,Select";
        new Sort().SortCompare(num, t, isShow, sortWay);
    }

    /**
     * 选择排序
     * 与每个元素进行比较，将需要的元素放到首位
     *
     * @param array int数组
     */
    private void SelectSort(int[] array) {
        for (int i = 0; i <array.length ; i++) {
            var max = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] > array[max]) {
                    max = j;
                }
            }

            var temp = array[i];
            array[i]=array[max];
            array[max]=temp;
        }
    }

    /**
     * 冒泡排序
     * 冒泡排序的基本思想是，对相邻的元素进行两两比较，顺序相反则进行交换，
     * 这样，每一趟会将最小或最大的元素“浮”到顶端，最终达到完全有序
     *
     * @param array int 数组
     */
    private void BubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            var isChange = false;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] < array[j + 1]) {
                    var temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                    isChange = true;
                }
            }
            if (!isChange) {
                break;
            }
        }
    }

    /**
     * 插入排序
     * 将新的元素插入已经排好序的数组之中
     *
     * @param array int数组
     */
    private void InsertSort(int[] array) {
        for (int i = 1; i <array.length; i++) {
            for (int j = i; j >0&&array[j]>array[j-1] ; j--) {
                var temp = array[j];
                array[j]=array[j-1];
                array[j-1]=temp;
            }
        }
    }

    /**
     * 希尔排序，基本插入排序的一种升级
     * 希尔排序为了加快速度简单地改进了插入排序， 交换不相邻的元素以对数组的局部
     * 进行排序， 并最终用插入排序将局部有序的数组排序
     * @param array int数组
     */
    private void HIllSort(int[] array) {
        int n = array.length;
        int h = 1 ; //比较的跨度
        while (h<n/3) h=3*h+1;
        while (h>=1){
            for (int i =h; i < n; i++) {
                for (int j = i; j >=h&&array[j]>array[j-h]; j-=h) {
                    var temp = array[j];
                    array[j]=array[j-h];
                    array[j-h]=temp;
                }
            }
            h/=3;
        }


    }

    /**
     * 生成t次，num长度的数组并比较选择排序和插入排序的时间
     * @param num 数组长度
     * @param t 比较次数
     * @param isShow 是否显示数组
     * @param sortWay  排序方式
     */
    private void SortCompare(int num, int t, boolean isShow, String sortWay) {

        for (int j = 0; j < t; j++) {
            int[] arr = new int[num];
            for (int i = 0; i < num; i++) {
                arr[i] = (int) (Math.random() * num);
            }
            if (isShow) print(arr);
            if (sortWay.contains("Hill")) {
                var array = arr.clone();
                Stopwatch sw = new Stopwatch();
                HIllSort(array);
                if (isShow) print(array);
                System.out.println(String.format("\n希尔排序的时间：%f", sw.elapsedTime()));
            }
            if (sortWay.contains("Insert")) {
                var array = arr.clone();
                Stopwatch sw = new Stopwatch();
                InsertSort(array);
                if (isShow) print(array);
                System.out.println(String.format("\n插入排序的时间：%f", sw.elapsedTime()));

            }
            if (sortWay.contains("Bubble")) {
                var array = arr.clone();
                Stopwatch sw = new Stopwatch();
                BubbleSort(array);
                if (isShow) print(array);
                System.out.println(String.format("\n冒泡排序的时间：%f", sw.elapsedTime()));

            }
            if (sortWay.contains("Select")) {
                var array = arr.clone();
                Stopwatch sw = new Stopwatch();
                SelectSort(array);
                if (isShow) print(array);
                System.out.println(String.format("\n选择排序的时间：%f", sw.elapsedTime()));
            }

            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }


    }

    /**
     * 打印数组
     * @param array int数组
     */
    private void print(int[] array) {
        for (int i : array) {
           System.out.print(i+",");
        }
        System.out.print('\n');
    }

}
