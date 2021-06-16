package Kmeans;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * kmeans 聚类算法，通常用于灰度图像二值化，通过模拟2个K点，根据每个数据距离K的远近分成2部分，求平均得出新的K值，直到2次结果完全相同
 * 时间复杂度： 待定
 */
public class KMeansUtil {

    public static int binarization(int[] arr,int width,int height){
        ArrayList<Integer> left_list=new ArrayList<>();
        ArrayList<Integer> right_list=new ArrayList<>();
        //随意拟定初始K值
        int k_left=0;
        int k_right=10000;
        int sum_left;
        int sum_right;

        do {
            sum_right=0;
            sum_left=0;
            right_list.clear();
            left_list.clear();
            //首次分类
            for (int i = 0; i < arr.length; i++) {
                if(Math.abs(arr[i]-k_left)>Math.abs(arr[i]-k_right)){
                    right_list.add(arr[i]);
                    sum_right+=arr[i];
                }else{
                    left_list.add(arr[i]);
                    sum_left+=arr[i];
                }
            }
            if(right_list.size()==0){
                k_right/=2;
                continue;
            }
            if(left_list.size()==0){
                k_left/=2;
                continue;
            }
            int k2 = sum_right/right_list.size();
            int k1 = sum_left/left_list.size();
            if(k1==k_left&&k2==k_right){
                break;
            }else {
                k_left=k1;
                k_right=k2;
                System.out.println(k1+"||"+k2);
            }
        }while (true);
        left_list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1>o2){
                    return -1;
                }else if(o1<o2){
                    return 1;
                }
                return 0;
            }
        });
        int val=left_list.get(0);
        System.out.println(val);
        return val;
    }

}
