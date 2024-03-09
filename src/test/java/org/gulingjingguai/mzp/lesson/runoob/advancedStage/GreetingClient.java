//package org.gulingjingguai.mzp.lesson.runoob.advancedStage;
//
//import java.net.*;
//import java.io.*;
//
//public class GreetingClient {
//    public static void main(String[] args) {
//        String serverName = args[0];
//        int port = Integer.parseInt(args[1]);
//        try {
//            System.out.println("请求IP为:" + serverName + "端口号为:" + port);
//            Socket client = new Socket(serverName, port);
//            //向服务端发送信息
////            OutputStream outToServer = client.getOutputStream();
////            DataOutputStream out = new DataOutputStream(outToServer);
////            out.writeUTF("发送文件");
//            //读取文件到BUfferReader
//            BufferedReader buff = new BufferedReader(new FileReader("test.txt"));
//            //将文件传送给服务器
//            PrintWriter print = new PrintWriter(client.getOutputStream(), true);
//            String line = null;
//            while ((line = buff.readLine()) != null) {
//                print.println(line);
//            }
//            client.shutdownOutput();
//            //接受服务端返回信息
//            InputStream inFromServer = client.getInputStream();
//            DataInputStream in = new DataInputStream(inFromServer);
//            System.out.println("状态为:" + in.readUTF());
//
//            buff.close();
//            client.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}