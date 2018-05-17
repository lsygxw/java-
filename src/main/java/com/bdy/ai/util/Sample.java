/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: Sample
 * Author:   apple
 * Date:     2018/5/14 下午6:52
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.bdy.ai.util;

import com.baidu.aip.face.AipFace;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author apple
 * @create 2018/5/14
 * @since 1.0.0
 */
public class Sample {
    //设置APPID/AK/SK
    public static final String APP_ID = "11239525";
    public static final String API_KEY = "R3MvedB4MmCPqXXwXcycOm1v";
    public static final String SECRET_KEY = "3YtNfqSiP10HgYyMQAU6x6Ut4jFOqG2P";

    public static AipFace getAipFace(){
        AipFace client = new AipFace(APP_ID, API_KEY, SECRET_KEY);
        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
        System.setProperty("aip.log4j.conf", "log4j.properties");
        System.out.println("Aip:" + client.toString());
        return client;
    }

}