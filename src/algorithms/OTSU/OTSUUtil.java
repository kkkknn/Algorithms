package algorithms.OTSU;

import static java.lang.Math.pow;

public class OTSUUtil {
    /**
     * 二值化运算
     * @param arr 灰度图像数据
     */
    public static int testRun(int[] arr,int width,int height){
        if(arr==null||arr.length==0)return -1;

        //灰度等级
        final int grayScale=256;
        int[] pixelCount=new int[grayScale];
        float[] pixelPro=new float[grayScale];
        int threshold=-1;

        //统计灰度级中每个像素在整幅图像中的个数
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                pixelCount[(int)arr[i * width + j]]++;  //将像素值作为计数数组的下标
            }
        }

        //计算每个像素在整幅图像中的比例
        float maxPro = 0.0f;
        int kk = 0;
        for (int i = 0; i < grayScale; i++) {
            pixelPro[i] = (float)pixelCount[i] / (width*height);
            if (pixelPro[i] > maxPro) {
                maxPro = pixelPro[i];
                kk = i;
            }
        }

        //遍历灰度级[0,255]
        float w0, w1, u0tmp, u1tmp, u0, u1, u, deltaTmp, deltaMax = 0;
        for (int i = 0; i < grayScale; i++){
            w0 = w1 = u0tmp = u1tmp = u0 = u1 = u = deltaTmp = 0;
            for (int j = 0; j < grayScale; j++) {
                if (j <= i){
                    w0 += pixelPro[j];
                    u0tmp += j * pixelPro[j];
                }else{
                    w1 += pixelPro[j];
                    u1tmp += j * pixelPro[j];
                }
            }
            u0 = u0tmp / w0;
            u1 = u1tmp / w1;
            u = u0tmp + u1tmp;
            deltaTmp = (float) (w0 * pow((u0 - u), 2) + w1 * pow((u1 - u), 2));
            if (deltaTmp > deltaMax){
                deltaMax = deltaTmp;
                threshold = i;
            }
        }
        System.out.println(threshold);
        return threshold;
    }
}
