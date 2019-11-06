package com.second;


import edu.princeton.cs.algs4.Stopwatch;

//排序算法
public class Sort {
    public static void main(String[] args) {

        var array = new int[]{1,4,3,2,5,6};
        //var randomInput = SortCompare.timeRandom-Input
        new Sort().SortCompare(10,10,true);
//        for (int i : array) {
//           System.out.println(i);
//        }
        //array
    }
    //选择排序:每个元素都进行比较
    public void SelectSort(int[] array){
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
    //插入排序，每次循环都进行相邻比较
    public void InsertSort(int[] array){
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
     * @param array
     */
    public void HIllSort(int[] array){
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
     */
    public void SortCompare(int num,int t,boolean isShow){

        for (int j = 0; j < t; j++) {
            int[] arr = new int[num];
            for (int i = 0; i < num; i++) {
                arr[i] = (int) (Math.random() * num);
            }

            var arr2 = arr.clone();
            if(isShow){
                print(arr);
            };

            Stopwatch iw = new Stopwatch();
            HIllSort(arr2);
            System.out.println(String.format("\n希尔排序的时间：%f",iw.elapsedTime()));
            if(isShow)print(arr2);

            continue;
//
////        Stopwatch iw = new Stopwatch();
////            long start = System.currentTimeMillis();
//            InsertSort(arr2);
////        System.out.println(String.format("\n插入排序的时间：%f",iw.elapsedTime()));
//            var now = System.currentTimeMillis();
//            System.out.println(String.format("\n插入排序的时间：%s", (now - start) / 1000.0));
//
//            Stopwatch sw = new Stopwatch();
//            SelectSort(arr);
//            System.out.println(String.format("\n选择排序的时间：%s", sw.elapsedTime()));
//            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }


    }

    /**
     * 打印数组
     * @param array
     */
    public void print(int[] array){
        for (int i : array) {
           System.out.print(i+",");
        }
        System.out.print('\n');
    }
}
