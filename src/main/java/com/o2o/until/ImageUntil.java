package com.o2o.until;


import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Position;
import net.coobird.thumbnailator.geometry.Positions;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 路径：D:/JAVA_top/Github/image/+upload/items/shop/"+shopId+"/"+文件随机名称+后缀(.jpg)
 * Created by tanke on 2018/9/20.
 */
public class ImageUntil {
    private static String basePath=Thread.currentThread().getContextClassLoader().getResource("").getPath();
    private static final SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMddHHmmss");
    private static final Random random=new Random();
     /**
     * generateThumbnails重载
     * @param thumbnails
     * @param targetAddr
     * @return
     */
    public static  String generateThumbnails(InputStream thumbnailsInputStream, String targetAddr,String fileName){
        String realFileName=getRandomFileName();
        String extension=getFileExtension(fileName);
        makeDirPath(targetAddr);
        String relativeAddr=targetAddr+realFileName+extension;
        File desk=new File(PathUntil.getImeBasePath()+relativeAddr);
        try{
            Thumbnails.of(thumbnailsInputStream)
                    .size(500, 500).watermark(
                    Positions.BOTTOM_RIGHT,
                    ImageIO.read(new File(basePath+"school.jpg")), 0.5f)
                    .outputQuality(0.8f).toFile(
                    desk);
        }catch (IOException e){
            e.printStackTrace();
        }
        return relativeAddr;
    }

    /**
     * 创建目标路径及所获得的路径
     * @param targetAddr
     */
    private static void makeDirPath(String targetAddr) {
        String realFileParentPath=PathUntil.getImeBasePath()+targetAddr;
        File dirPath=new File(realFileParentPath);
        if(!dirPath.exists()){
            dirPath.mkdirs();
        }
    }
    /**
     *获取输入流的扩展名png jpg
     * @param
     * @return
     */

    private static String getFileExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }
    /**
     * 生成随机名称的文件
     * @return
     */
    public static String getRandomFileName() {
        int number=random.nextInt(8999)+10000;
        String data=simpleDateFormat.format(new Date());
        return data+number;

    }
}
