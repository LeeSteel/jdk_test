package utils;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description:  欣宝 照片文件夹 工具类
 * @author: 李钢 2580704698@qq.com
 * @date: 2023/4/13 15:39
 * @Copyright: Copyright (c) 2019
 */
public class PhotoFolderUtil {
    static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");

    public static void main(String[] args) {

//        LocalDate beginLocalDate = LocalDate.of(2022, 1, 3);
//        LocalDate endLocalDate = LocalDate.of(2023, 1, 3);
//        String basicPath = "H:\\欣宝相册\\2022-2023【零岁】";

        LocalDate beginLocalDate = LocalDate.of(2023, 1, 3);
        LocalDate endLocalDate = LocalDate.of(2024, 1, 3);
        String basicPath = "H:\\欣宝成长相册\\2023-2024【一岁】";





        for (; beginLocalDate.isBefore(endLocalDate); ) {

            String dateStr = dateTimeFormatter.format(beginLocalDate);

            File parentFolder = new File(basicPath);
            String[] folders = parentFolder.list();
            String tempPath = basicPath + "\\" + dateStr;
            File folderFile = new File(tempPath);
            if (!folderFile.exists() &&
                    !Arrays.stream(folders).filter(f-> f.startsWith(dateStr))
                    .findFirst().isPresent()) {
                System.out.println(tempPath);
//                folderFile.mkdir();
            }

            if (folderFile.exists()) {
                File[] list = folderFile.listFiles();
                if ( list == null || list.length == 0){
                    System.out.println("空目录: "+tempPath+",删除");
                    folderFile.delete();
                }
            }

            beginLocalDate = beginLocalDate.plus(1, ChronoUnit.DAYS);
        }

    }
}
