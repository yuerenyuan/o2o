package com.o2o.until;

/**
 * Created by tanke on 2018/9/20.
 */
public class PathUntil {
    private static  String separator=System.getProperty("file.separator");
    public static String getImeBasePath() {
        String os = System.getProperty("os.name");
        String basePath = "";
        if (os.toLowerCase().startsWith("win")) {
            basePath = "D:/JAVA_top/Github/image/";
        } else {
            basePath = "/home/xiangze/image/";
            basePath.replace("/", separator);
        }
        return basePath;
    }
    public static String getShopImagePath(Integer shopId){
        String imagePath="upload/items/shop"+shopId+"/";
        imagePath.replace("/",separator);
        return imagePath;
    }
}
