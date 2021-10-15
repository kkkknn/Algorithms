package algorithms.排序算法.选择排序;

import java.util.Arrays;

/**
 * 选择排序
 * 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置。
 *
 * 再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
 *
 * 重复第二步，直到所有元素均排序完毕。
 */
public class Test {

    //选择排序
    private int[] sort(int[] arr){
        int minIndex,temp;
        int len=arr.length;
        for (int i = 0; i < len-1; i++) {
            minIndex=i;
            for (int j = i+1; j < len; j++) {
                if(arr[j]<arr[minIndex]){
                    minIndex=j;
                }
            }
            //交换位置
            temp=arr[i];
            arr[i]=arr[minIndex];
            arr[minIndex]=temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        Test test=new Test();
        int[] arr={123,4124,1,5,212,56,67,4,3,623,478,7545231};
        System.out.println("排序前："+ Arrays.toString(arr));
        System.out.println("=============================");
        test.sort(arr);
        System.out.println("排序后："+Arrays.toString(arr));
    }
}
