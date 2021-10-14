package algorithms.排序算法.冒泡排序;

import java.util.Arrays;

public class Test {
    //冒泡排序
    public int[] sortNum(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            boolean flag=false;//判断值，如果此次内部循环没有发生一次调换，可认为此数组排序已经完成
            for (int j = 0; j < arr.length-i; j++) {
                if(arr[j]>arr[j+1]){
                    flag=true;
                    int tmp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=tmp;
                }
            }
            if(flag){
                break;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Test t=new Test();
        int[] arr={123,4124,1,5,212,56,67,4,3,623,478,7545231};
        System.out.println("排序前："+Arrays.toString(arr));
        System.out.println("=============================");
        arr=t.sortNum(arr);
        System.out.println("排序后："+Arrays.toString(arr));
    }
}
