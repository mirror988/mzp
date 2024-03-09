package org.gulingjingguai.mzp.lesson.runoob.advancedStage;

import java.net.*;
import java.io.*;

public class GreetingClient {
    public static void main(String[] args) {
        String serverName = args[0];
        int port = Integer.parseInt(args[1]);
        try {
            System.out.println("请求IP为:" + serverName + "端口号为:" + port);
            Socket client = new Socket(serverName, port);
            //向服务端发送信息
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);
            out.writeUTF("你好");
            //读取文件到BUfferReader
            client.shutdownOutput();
            //接受服务端返回信息
            InputStream inFromServer = client.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);
            System.out.println("状态为:" + in.readUTF());
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}