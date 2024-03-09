package org.gulingjingguai.mzp.lesson.runoob.advancedStage;

import sun.nio.cs.ext.GBK;

import java.net.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class URLConnDemo
{
    public static void main(String [] args)
    {
        try
        {
            URL url = new URL("https://www.runoob.com/java/java-networking.html");
            URLConnection urlConnection = url.openConnection();
            HttpURLConnection connection = null;
            if(urlConnection instanceof HttpURLConnection)
            {
                connection = (HttpURLConnection) urlConnection;
            }
            else
            {
                System.out.println("请输入 URL 地址");
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            InputStream inputStream = connection.getInputStream();
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                // 处理数据
                stringBuilder.append(bytesRead);
            }
            String current;
            System.out.println(stringBuilder);
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
