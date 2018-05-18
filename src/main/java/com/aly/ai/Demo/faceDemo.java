/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: faceDemo
 * Author:   apple
 * Date:     2018/5/16 下午4:04
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.aly.ai.Demo;

import com.aly.ai.utils.FileUtil;
import com.aly.ai.utils.Util;

import java.io.File;
import java.util.Scanner;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author apple
 * @create 2018/5/16
 * @since 1.0.0
 */
public class faceDemo {

    public static void main(String[] args) {
        faceDemo f = new faceDemo();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("请输入姓名(输入0结束程序):");
            String name = sc.next();
            if (name == "0") break;
            f.ImageFace(name);
        }
    }

    public void ImageFace(String name) {

        long startTime = System.currentTimeMillis();   //获取开始时间
        try {
            System.out.println("系统开始运行");
            File file = new File(FileUtil.getUrl + "/FaceData/Pics/");
            String[] files = file.list();//遍历该文件夹
            for (int j = 1; j < files.length; j++) {
                if(!files[j].endsWith(".jpg")){
                    continue;
                }
                String i = files[j].substring(0,files[j].lastIndexOf('.'));
                // 获得筛选的图片
                String Base = Util.GetImageStrFromPath(new File(FileUtil.getUrl + "/FaceData/Pics/" + i + ".jpg"));
                // 超过百分之70置信度则返回1
                int data = ImageFace.BaseFace(Base, String.valueOf(i), name);
                if (data == 1) {
                    // 检查是否有此文件
                    FileUtil.checkFile(name);
                    FileUtil.copyImage(new File(FileUtil.getUrl + "/FaceData/Pics/" + i + ".jpg"), "JPG"
                            , new File(FileUtil.getUrl + "/FaceData/" + name + "/" + i + ".jpg"));
                    System.out.println("完成存库!");
                    System.out.println("---------------------");
                }
            }
//            for (int i = 1; i <= 30; i++) {
//                // 获得筛选的图片
//                String Base = Util.GetImageStrFromPath(new File(FileUtil.getUrl + "/FaceData/Pics/" + i + ".jpg"));
//                // 超过百分之70置信度则返回1
//                int data = ImageFace.BaseFace(Base, String.valueOf(i), "王祖蓝");
//                if (data == 1) {
//                    FileUtil.checkFile("王祖蓝");
//                    FileUtil.copyImage(new File(FileUtil.getUrl + "/FaceData/Pics/" + i + ".jpg"), "JPG"
//                            , new File(FileUtil.getUrl + "/FaceData/王祖蓝/" + i + ".jpg"));
//                    System.out.println("完成存库!");
//                    System.out.println("---------------------");
//                }
//            }
            long endTime = System.currentTimeMillis(); //获取结束时间
            System.out.println("所有照片筛选完毕,用时：" + (endTime - startTime) + "ms");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}