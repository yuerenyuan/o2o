package com.o2o.until;


import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Position;
import net.coobird.thumbnailator.geometry.Positions;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by tanke on 2018/9/20.
 */
public class ImageUntil {
    private static String basePath=Thread.currentThread().getContextClassLoader().getResource("").getPath();
    private static final SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMddHHmmss");
    private static final Random random=new Random();
    public static  String generateThumbnails(CommonsMultipartFile thumbnails,String targetAddr){
        String realFileName=getRandomFileName();
        String extension=getFileExtension(thumbnails);
        makeDirPath(targetAddr);
        String relativeAddr=targetAddr+realFileName+extension;
        File desk=new File(PathUntil.getImeBasePath()+relativeAddr);
        try{
            Thumbnails.of(thumbnails.getInputStream())
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

    private static String getFileExtension(CommonsMultipartFile cFile) {
        String originalFileName=cFile.getOriginalFilename();
        return originalFileName.substring(originalFileName.lastIndexOf("."));
    }

    /**
     * 生成随机名称的文件
     * @return
     */
    private static String getRandomFileName() {
        int number=random.nextInt(8999)+10000;
        String data=simpleDateFormat.format(new Date());
        return data+number;

    }



}
