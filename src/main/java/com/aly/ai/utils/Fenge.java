/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: Fenge
 * Author:   apple
 * Date:     2018/5/15 下午3:59
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.aly.ai.utils;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author apple
 * @create 2018/5/15
 * @since 1.0.0
 */
public class Fenge {
    public final static void cutImage(String srcImageFile, String result,
                                      int destWidth, int destHeight) {
        try {
            Iterator iterator = ImageIO.getImageReadersByFormatName("JPEG");/*PNG,BMP*/
            ImageReader reader = (ImageReader) iterator.next();/*获取图片尺寸*/
            InputStream inputStream = new FileInputStream(srcImageFile);
            ImageInputStream iis = ImageIO.createImageInputStream(inputStream);
            reader.setInput(iis, true);
            ImageReadParam param = reader.getDefaultReadParam();
            Rectangle rectangle = new Rectangle(185, 56, destWidth, destHeight);/*指定截取范围*/
            param.setSourceRegion(rectangle);
            BufferedImage bi = reader.read(0, param);
            ImageIO.write(bi, "JPEG", new File(result));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // 剪裁
    public static boolean cropImage(File inputStream, int x, int y, int w, int h, String sufix, File file) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(inputStream);
        bufferedImage = bufferedImage.getSubimage(x,y,w,h);
        return ImageIO.write(bufferedImage,sufix,file);
    }

}