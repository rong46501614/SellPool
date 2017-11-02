package com.xftx.xingfeng.fileutils;

/**
 * Created by xingfeng on 2017/8/26.
 */
public class ImportUserProfile {
    public static void importFile(String importFilePath){
        String userFile = ReadExcelFile.readExcelFileToJson(importFilePath).toString();
        String filePath = FileUtil.getFilePath()+"/SellPool/User/";
        String fileName = "user.json";
        FileUtil.writeTxtToFile(userFile, filePath, fileName);
    }
}
