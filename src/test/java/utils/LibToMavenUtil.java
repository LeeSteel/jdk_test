package utils;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description: 本地Lib 转换为 maven <dependency>工具
 * @author: 李钢 2580704698@qq.com
 * @date: 2023/4/18 16:04
 * @Copyright: Copyright (c) 2019
 */
public class LibToMavenUtil {

    static final String FOLDER_SEPARATOR = "/";


    public static void main(String[] args) {
        String libPath = "F:\\idea-workspace\\newvane-projects\\mishu_202304\\mishu_ppt_app\\src\\main\\webapp\\WEB-INF\\lib";
        String targetPath = "${project.basedir}/src/main/webapp/WEB-INF/lib/";
        printMavenDependency(selectLibNameList(libPath), targetPath);
    }

    /**
     *  获取文件名 列表
     * @param libPath
     * @return
     */
    public static List<String> selectLibNameList(String libPath) {
        File folder = new File(libPath);
        if (folder.exists()) {
            String[] list = folder.list();
            return Arrays.stream(list).collect(Collectors.toList());
        }

        return Collections.emptyList();
    }

    /**
     *  打印 maven 标签到控制台
     * @param fileNameList
     * @param targetPath
     */
    public static void printMavenDependency(List<String> fileNameList, String targetPath) {
        if (Objects.isNull(fileNameList) || fileNameList.isEmpty()) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();

        fileNameList.stream().forEach(libName -> {
            String subLibName = libName.substring(0, libName.indexOf(".jar"));
            String version = "1.0.0";
            if (libName.indexOf("-") != -1) {
                for (int index = 1; index < 10; index++) {
                    int forIndex = 0;
                    for (int j = 1; j < index; j++) {
                        forIndex = libName.indexOf("-", forIndex) + 1;
                    }
                    if (libName.indexOf("-", forIndex) != -1) {
                        String tempSubLibName = libName.substring(0, libName.indexOf("-", forIndex));
                        String tempVersion = libName.substring(tempSubLibName.length() + 1, libName.indexOf(".jar"));
                        int chr = tempVersion.charAt(0);
                        boolean isNumeric = (chr >= 48 && chr <= 57);
                        if (isNumeric) {
                            subLibName = tempSubLibName;
                            version = tempVersion;
                            break;
                        }
                    }
                }
            }
            stringBuilder.append("<dependency>").append("\n")
                    .append("\t<groupId>").append(subLibName).append("</groupId>").append("\n")
                    .append("\t<artifactId>").append(subLibName).append("</artifactId>").append("\n")
                    .append("\t<version>").append(version).append("</version>").append("\n")
                    .append("\t<scope>system</scope>").append("\n")
                    .append("\t<systemPath>").append(targetPath).append(libName).append("</systemPath>").append("\n")
                    .append("</dependency>").append("\n");
        });
        System.out.println(stringBuilder.toString());

    }
}
