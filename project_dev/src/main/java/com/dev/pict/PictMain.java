package com.dev.pict;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class PictMain {

    static BASE64Encoder encoder = new BASE64Encoder();

    public static void main(String[] args) throws IOException {

        String string = imageToString("pict/Snipaste_2019-03-12_16-43-36.jpg");
        Integer size = imageSize(string);

        System.out.println(string);
        System.out.println(size);

        stringToImage(string);

    }

    public static void stringToImage(String string) throws IOException {
        BASE64Decoder decoder=new BASE64Decoder();

        byte[] bytes=decoder.decodeBuffer(string);

        File file=new File("D:/a.jpeg");

        FileOutputStream fos=new FileOutputStream(file);

        fos.write(bytes);

        fos.flush();
        fos.close();
    }

    public static Integer imageSize(String image){
        String str=image.substring(22); // 1.需要计算文件流大小，首先把头部的data:image/png;base64,（注意有逗号）去掉。
        Integer equalIndex= str.indexOf("=");//2.找到等号，把等号也去掉
        if(str.indexOf("=")>0) {
            str=str.substring(0, equalIndex);
        }
        Integer strLength=str.length();//3.原来的字符流大小，单位为字节
        Integer size=strLength-(strLength/8)*2;//4.计算后得到的文件流大小，单位为字节
        return size;
    }

    public static String imageToString(String path) {
        ClassLoader classLoader = PictMain.class.getClassLoader();
        URL url = classLoader.getResource(path);
        File file = new File(url.getFile());
        BufferedImage bi;
        try {

            bi = ImageIO.read(file);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bi, "jpg", baos);
            byte[] bytes = baos.toByteArray();

            String result = encoder.encodeBuffer(bytes).trim();
            return result;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
