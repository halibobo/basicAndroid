package me.dahei.basicandroid;

import android.content.Context;

import java.io.File;

/**
 * created by yubosu
 * 2019年02月01日10:43 AM
 */
public class InterFileAnalysis {


    public static void analysisFile(Context context) {

        String dirPath = context.getFilesDir().getAbsolutePath();
        File tempFile = new File(dirPath);
        listFile(tempFile);
    }

    private static void listFile(File f) {
        File[] files = f.listFiles();
        if (files == null) {
            return;
        }

        for (File file : files) {
            //如果是文件夹
            if (file.isDirectory()) {
                //则递归(方法自己调用自己)继续遍历该文件夹
                listFile(file);
            } else { //如果不是文件夹 则是文件
                //如果文件名以 .mp3结尾则是mp3文件
                System.out.println(file.getAbsoluteFile() + ":" + file.length());
            }
        }
    }

}
