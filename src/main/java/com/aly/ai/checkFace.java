/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: checkFace
 * Author:   apple
 * Date:     2018/5/15 下午2:59
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.aly.ai;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author apple
 * @create 2018/5/15
 * @since 1.0.0
 * <p>
 * 检测人脸数量
 */
public class checkFace {
//
//    @faceDemo
//    public void check() {
//        try {
//            ArrayList<String> listdata = new ArrayList<String>();
//            String image = Util.GetImageStrFromPath("/Users/apple/images/yuantu/dc.jpeg");
//            String body = "{\"type\":1 , \"content\": \""+image+"\"}";
//            Map map = Key.jsonObject(Util.sendPost(Key.UrlAttribute, body, Key.ak_id, Key.ak_secret));
////            Map map = object;
//            String str = map.get("face_rect").toString();
//            str = str.substring(1, str.length() - 1);
//            String[] data = str.split(",");
//
//            for (int i = 0; i < data.length ; i+= 4) {
//                int x = Integer.parseInt(data[i]);
//                int y = Integer.parseInt(data[i + 1]);
//                int w = Integer.parseInt(data[i + 2]);
//                int h = Integer.parseInt(data[i + 3]);
//                Fenge.cropImage(new File("/Users/apple/images/yuantu/dc.jpeg"), x, y, w, h, "JPEG", new File("/Users/apple/images/jianqie/jq.jpeg"));
//                // 拿到本地编码
//                String imaged = Util.GetImageStrFromPath("/Users/apple/images/yuantu/dengchao.jpeg");
//                String imagev = Util.GetImageStrFromPath("/Users/apple/images/jianqie/jq.jpeg");
//
//                String bodyv = "{\"type\" : 1 , \"content_1\" :\""+ imaged +"\",\"content_2\":\""+imagev+"\"}";
//                map = Key.jsonObject(Util.sendPost(Key.UrlVerify, bodyv, Key.ak_id, Key.ak_secret));
////               map = object;
//                System.out.println();
//            }
////                System.out.println(Fenge.cropImage(new File("/Users/apple/images/yuantu/dc.jpeg"), 185, 56, 211 - 56, 185 - 56, "JPEG", new File("/Users/apple/images/jianqie/jq.jpeg")));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

}