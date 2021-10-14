package algorithms.OTSU;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        BufferedImage image=null;
        try {
            image= ImageIO.read(new File("src/source/images/test2.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(image==null)return;
        //读取图像并转换灰度数组
        int width=image.getWidth();
        int height= image.getHeight();
        int[] arr=new int[width*height];
        int[] gray_arr=new int[width*height];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                //拆分argb值
                int pixel=image.getRGB(j,i);
                int alpha=(pixel>>24) & 0xff;
                int red=(pixel>>16) & 0xff;
                int green=(pixel>>8) & 0xff;
                int blue=(pixel) & 0xff;
                //此处使用平均值法来粗略算出灰度值
                int avg=(red+green+blue)/3;
                //保存灰度数值
                arr[i*width+j]=avg;
                //保存灰度图像
                gray_arr[i*width+j]=(alpha << 24) | (avg << 16) | (avg << 8) | avg;
            }
        }
        //保存当前保存的灰度图像
        BufferedImage gray_image=new BufferedImage(width,height,BufferedImage.TYPE_BYTE_GRAY);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int gray=gray_arr[i*width+j];
                gray_image.setRGB(j,i,gray);
            }
        }
        try {
            writeImageFile(gray_image,"gray.jpg");
        } catch (IOException e) {
            e.printStackTrace();
        }
        int val=OTSUUtil.testRun(arr,width,height);
        if(val>=0){
            BufferedImage value_image=new BufferedImage(width,height,BufferedImage.TYPE_BYTE_GRAY);
            //根据K值处理图像数组
            for (int i = 0; i < arr.length; i++) {
                if(arr[i]<=val){
                    arr[i]=1;
                }else {
                    arr[i]=0;
                }
            }
            //写入图像数据
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if(arr[i*width+j]==1){
                        value_image.setRGB(j,i,Color.BLACK.getRGB());
                    }else {
                        value_image.setRGB(j,i,Color.WHITE.getRGB());
                    }
                }
            }
            //保存图像
            try {
                writeImageFile(value_image,"value.jpg");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    //保存图像文件
    private static void writeImageFile(BufferedImage bi,String fileName) throws IOException {
        File outputfile = new File("src/algorithms.OTSU/"+fileName);
        String[] arr=fileName.split("\\.");
        ImageIO.write(bi, arr[1], outputfile);
    }


}
