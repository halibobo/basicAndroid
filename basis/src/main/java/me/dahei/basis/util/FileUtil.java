package me.dahei.basis.util;

import android.content.Context;
import android.os.Environment;

import java.io.File;
import java.io.IOException;

/**
 * created by yubosu
 * 2018年07月31日上午10:00
 */
public class FileUtil {

    private static final String LOCAL_PATH = "basic_android";

    public static File getFilePath(Context context, String name) {

        File dirRootFile = context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS+LOCAL_PATH);

        if (dirRootFile != null && !dirRootFile.exists()) {
            dirRootFile.mkdirs();
        }
        File file = new File(dirRootFile.getPath() + File.separator + name);

        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;

    }

}
