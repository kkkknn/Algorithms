package algorithms.排序算法.插入排序;

import java.util.Arrays;

public class Test {
    public void sort(int[] arr){
        int len= arr.length;
        int thisIndex,temp;
        for (int i = 1; i < len; i++) {
            thisIndex=i-1;
            temp=arr[i];
            while (thisIndex>=0&&arr[thisIndex]>temp){
                arr[thisIndex+1]=arr[thisIndex];
                thisIndex--;
            }
            arr[thisIndex+1]=temp;
        }
    }

    public static void main(String[] args) {
        int[] arr={123,4124,1,5,212,56,67,4,3,623,478,7545231};
        System.out.println("排序前："+ Arrays.toString(arr));
        System.out.println("=============================");
        new Test().sort(arr);
        System.out.println("排序后："+Arrays.toString(arr));
    }
}
