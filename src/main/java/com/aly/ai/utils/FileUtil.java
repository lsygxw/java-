/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: FileUtil
 * Author:   apple
 * Date:     2018/5/16 下午4:26
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.aly.ai.utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author apple
 * @create 2018/5/16
 * @since 1.0.0
 */
public class FileUtil {

    // 获得系统当前路径
    public static final String getUrl = System.getProperty("user.dir");

    public static boolean copyImage(File inputStream, String sufix, File file) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(inputStream);
        return ImageIO.write(bufferedImage,sufix,file);
    }

    // 检查是否有此文件夹,如果没有则创建
    public static int checkFile(String name){
        File file = new File(FileUtil.getUrl +"/FaceData/" + name);
        if(!file.exists()){
            file.mkdirs();
            System.out.println("------------------------");
            System.out.println("-                      -");
            System.out.println("-      已创建"+name+"目录");
            System.out.println("-                      -");
            System.out.println("------------------------");
            return 1;
        }
        return 0;
    }

}