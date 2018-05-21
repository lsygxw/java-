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
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author apple
 * @create 2018/5/16
 * @since 1.0.0
 */
public class faceDemo implements Runnable {

    private String name;
    private List<String> list;
    static CountDownLatch cdl;

    public faceDemo(String name, List<String> list) {
        this.name = name;
        this.list = list;
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        while (true) {
            Thread.sleep(100);
            System.out.print("请输入姓名(输入0结束程序):");
            String name = sc.next();
            if (name == "0") break;
            name.replace(" ", "");

            if (FileUtil.checkFileName(FileUtil.getUrl + "/FaceData/", name + ".jpg") != 1) {
                System.out.println("系统中并无" + name + "这个人!!");
                continue;
            }

            long startTime = System.currentTimeMillis();   //获取开始时间

            System.out.println("系统开始运行");

            System.out.println("正在分配系统资源.....");

            // 获得照片库中的所有文件
            File file = new File(FileUtil.getUrl + "/FaceData/Pics/");

            String[] files = file.list();//遍历该文件夹

            int dy = files.length / 5;

            int index = files.length % dy == 0 ? files.length / dy : files.length / dy + 1;

            cdl = new CountDownLatch(index);

            System.out.println("系统资源分配完成.....");

            dynamicAllocation(name, files, dy);

            cdl.await();

            long endTime = System.currentTimeMillis(); //获取结束时间

            System.out.println("所有照片筛选完毕,用时：" + (endTime - startTime) + "ms");

        }
    }

    public static void dynamicAllocation(String name, String[] files, int dy) throws InterruptedException {
//        File file = new File(FileUtil.getUrl + "/FaceData/Pics/");
//        String[] files = file.list();//遍历该文件夹
        int index = 0;
        while (index + dy <= files.length) {
            List<String> list = new ArrayList<>();
            for (int i = index; i < index + dy; i++) {
                list.add(files[i]);
            }
            index += dy;
            faceDemo faceDemo = new faceDemo(name, list);
            new Thread(faceDemo).start();
        }
        if (index < files.length) {
            List<String> list = new ArrayList<>();
            for (int i = index; i < files.length; i++) {
                list.add(files[i]);
            }
            new Thread(new faceDemo(name, list)).start();
        }

    }


    public static void ImageFace(String name, List<String> list) {

//        long startTime = System.currentTimeMillis();   //获取开始时间
        try {
//            File file = new File(FileUtil.getUrl + "/FaceData/Pics/");
//            String[] files = file.list();//遍历该文件夹
            for (String files : list) {
                if (!files.endsWith(".jpg")) {
                    continue;
                }
                String ImageUUID = files.substring(0, files.lastIndexOf('.'));
                // 获得筛选的图片
                String Base = Util.GetImageStrFromPath(new File(FileUtil.getUrl + "/FaceData/Pics/" + ImageUUID + ".jpg"));
                // 超过百分之70置信度则返回1
                int data = ImageFace.BaseFace(Base, String.valueOf(ImageUUID), name);
                if (data == 1) {
                    // 检查是否有此文件
                    FileUtil.checkFile(name);
                    FileUtil.copyImage(new File(FileUtil.getUrl + "/FaceData/Pics/" + ImageUUID + ".jpg"), "JPG"
                            , new File(FileUtil.getUrl + "/FaceData/" + name + "/" + ImageUUID + ".jpg"));
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
//            long endTime = System.currentTimeMillis(); //获取结束时间
//            System.out.println("所有照片筛选完毕,用时：" + (endTime - startTime) + "ms");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        ImageFace(name, list);
        cdl.countDown();
    }
}