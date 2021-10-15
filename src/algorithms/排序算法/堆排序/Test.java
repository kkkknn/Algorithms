package algorithms.排序算法.堆排序;

import java.util.Arrays;

public class Test {
    private int[] sort(int[] arr){
        //生成大项堆
        for (int i = arr.length/2-1; i >=0 ; i--) {
            //从第一个非子叶节点从下往上，从右至左调整结构
            adjustHeap(arr,i,arr.length);
        }
        //调整堆结构
        for (int i = arr.length-1; i >0; i--) {
            swap(arr,0,i);
            adjustHeap(arr,0,i);
        }
        return arr;
    }

    private void adjustHeap(int[] arr,int i,int len){
        int temp=arr[i];
        for (int j = i*2+1; j < len; j=j*2+1) {
            if(j+1<len&&arr[j]<arr[j+1]){
                j++;
            }
            if(arr[j]>temp){
                arr[i]=arr[j];
                i=j;
            }else {
                break;
            }
        }
        arr[i]=temp;
    }

    private static void swap(int []arr,int a ,int b){
        int temp=arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


    public static void main(String[] args) {
        Test t=new Test();
        int[] arr={12,3,5412,5,12,56,32,5,12,6,45,345,23,5634,5,3245,34};
        System.out.println("排序前："+ Arrays.toString(arr));
        System.out.println("===========================");
        arr=t.sort(arr);
        System.out.println("排序后："+Arrays.toString(arr));
    }
}
