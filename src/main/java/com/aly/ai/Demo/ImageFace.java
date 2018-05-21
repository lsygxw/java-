/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: ImageFace
 * Author:   apple
 * Date:     2018/5/16 下午3:01
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.aly.ai.Demo;

import com.aly.ai.utils.Fenge;
import com.aly.ai.utils.FileUtil;
import com.aly.ai.utils.Key;
import com.aly.ai.utils.Util;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author apple
 * @create 2018/5/16
 * @since 1.0.0
 */
public class ImageFace {
    /**
     * @param Base Base64位编码
     *             path
     * @return 返回一组坐标
     */
    public static int BaseFace(String Base, String ImageUUID, String name) throws IOException, InterruptedException {
        String body = "{\"type\":1 , \"content\": \"" + Base + "\"}";
        // 返回一组Json
        Map map = Key.jsonObject(Util.sendPost(Key.UrlDetect, body, Key.ak_id, Key.ak_secret));
        // 把坐标转化成字符串
        String str = map.get("face_rect").toString();
        // 除去字符串前后的[]
        str = str.substring(1, str.length() - 1);
        // 正则表达式,切割所有坐标
        String[] data = str.split(",");
        // 每四个为一组坐标
        System.out.println("照片完成解析,发现" + data.length / 4 + "张人脸");
        int index = 1;
        for (int i = 0; i < data.length; i += 4) {
            int x = Integer.parseInt(data[i]);
            int y = Integer.parseInt(data[i + 1]);
            int w = Integer.parseInt(data[i + 2]);
            int h = Integer.parseInt(data[i + 3]);
            System.out.println("正在解析第" + index + "张人脸...");
            // 剪切人脸,,存储剪切后的人脸
            String JQImageName = ImageUUID + UUID.randomUUID();
            Fenge.cropImage(new File(FileUtil.getUrl + "/FaceData/Pics/" + ImageUUID + ".jpg"), x, y, w, h, "JPG", new File(FileUtil.getUrl + "/FaceData/Split/" + JQImageName + ".jpg"));
            float confidence = comparisonFace(JQImageName, name);
            System.out.println("解析完成,第" + index + "张人脸与" + name + "的相似度为:" + confidence + "%");
            System.out.println("----------------------------------------");
            index++;
            if (confidence >= 70) {
                System.out.println("系统在此照片已匹配到与" + name + "相似的人脸,正在执行存库...");
                return 1;
            }
        }
        System.out.println("系统在此照片中未找到与" + name + "相似的人脸");
        System.out.println("-------------------------");

        return 0;
    }

    /**
     * 比对人脸
     *
     * @return 分辨率
     */
    public static float comparisonFace(String JQImageName, String name) throws IOException, InterruptedException {
        // 拿到原图的Base
        String imageA = Util.GetImageStrFromPath(new File(FileUtil.getUrl + "/FaceData/" + name + ".jpg"));
        // 拿到对比图的Base
        String imageB = Util.GetImageStrFromPath(new File(FileUtil.getUrl + "/FaceData/Split/" + JQImageName + ".jpg"));
        // 返回一组对比数据
        String body = "{\"type\" : 1 , \"content_1\" :\"" + imageA + "\",\"content_2\":\"" + imageB + "\"}";
        // 通过post处理 
        Map map = Key.jsonObject(Util.sendPost(Key.UrlVerify, body, Key.ak_id2, Key.ak_secret2));

        String str = map.get("confidence").toString();
        return Float.parseFloat(str);
    }
}