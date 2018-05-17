/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: Key
 * Author:   apple
 * Date:     2018/5/15 下午3:03
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.aly.ai.utils;

import net.sf.json.JSONObject;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author apple
 * @create 2018/5/15
 * @since 1.0.0
 */
public class Key {

    public static final String ak_id = "LTAIuCKlVXuysIOq";       //用户ak
    public static final String ak_secret = "XMW9zU2jB3pHxxdCS6UsbiZiSLo23T"; // 用户ak_secret
    //  人脸属性识别url
    public static final String UrlAttribute = "https://dtplus-cn-shanghai.data.aliyuncs.com/face/attribute";
    //  人脸比对识别url
    public static final String UrlVerify = "https://dtplus-cn-shanghai.data.aliyuncs.com/face/verify";
    //  人脸检测识别url
    public static final String UrlDetect = "https://dtplus-cn-shanghai.data.aliyuncs.com/face/detect";

    public static JSONObject jsonObject(String json){
        return JSONObject.fromObject(json);
    }
    public static void print(JSONObject jsonObject){
        System.out.println(jsonObject.toString());
    }
}