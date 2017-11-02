package com.xftx.xingfeng.fileutils;

import android.os.Environment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by xingfeng on 2017/8/12.
 */
public class FileUtil {

    public static String getFilePath(){
        boolean adCard = Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
        if(adCard){
            File sdCardDir = Environment.getExternalStorageDirectory();
            return sdCardDir.getPath();
        }
        return "/";
    }

        public static void writeTxtToFile(String content, String filePath, String fileName) {
            FileOutputStream fop = null;
            File file;
            try {
                file = new File(filePath+fileName);
                fop = new FileOutputStream(file);
                // if file doesnt exists, then create it
                if (!file.exists()) {
                    file.createNewFile();
                }
                // get the content in bytes
                byte[] contentInBytes = content.getBytes();
                fop.write(contentInBytes);
                fop.flush();
                fop.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (fop != null) {
                        fop.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    /**
     * 以行为单位读取文件，常用于读面向行的格式化文件
     */
    public static String readFileByLines(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        StringBuffer sb = new StringBuffer();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
               sb.append(tempString);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return sb.toString();
    }

}
