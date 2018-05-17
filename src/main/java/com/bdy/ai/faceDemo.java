/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: faceDemo
 * Author:   apple
 * Date:     2018/5/14 下午6:26
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.bdy.ai;

import com.baidu.aip.face.AipFace;
import com.bdy.ai.util.Sample;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author apple
 * @create 2018/5/14
 * @since 1.0.0
 */
public class faceDemo {
    public static void sample(AipFace client){
        HashMap<String, String> options = new HashMap<>();

        String image = "http://a.hiphotos.baidu.com/baike/pic/item/bba1cd11728b471019f3d528c9cec3fdfd032371.jpg";
        String imageType = "URL";
        JSONObject res = client.detect(image, imageType, options);
        System.out.println(res.toString());
    }
    public static void main(String[] args){
        sample(Sample.getAipFace());
    }

}