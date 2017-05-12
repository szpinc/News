package com.szp.util;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by Administrator on 2017/5/7.
 */
public class FileUploadUtil {

    public static void upload (InputStream in, String rootPath,String fileName) {
        File file = new File(rootPath);
        if (!file.exists()){
            file.mkdirs();
        }

        int len = 0;
        byte[] buf = new byte[1024];
        try {
            FileOutputStream out = new FileOutputStream(new File(file, fileName));
            while (-1!=(len=in.read(buf))){
                out.write(buf,0,len);
                out.flush();
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
