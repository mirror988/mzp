package org.gulingjingguai.mzp.lesson.runoob.advancedStage;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class GreetingServer extends Thread
{
    private ServerSocket serverSocket;

    public GreetingServer(int port) throws IOException
    {
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(10000);
    }

    public void run()
    {
        while(true)
        {
            try
            {
                System.out.println("服务器端口号为:" + serverSocket.getLocalPort() + "等待客户端连接...");
                Socket server = serverSocket.accept();
                //接受客户端信息
//                DataInputStream in = new DataInputStream(server.getInputStream());
//                System.out.println(in.readUTF());
                //读取接收到的文件数据
                BufferedReader buff = new BufferedReader(new InputStreamReader(server.getInputStream()));
                PrintWriter print  = new PrintWriter(new FileWriter( "miao.txt"),true);
                String line = null;
                while((line = buff.readLine()) != null){
                    print.println(line);
                }
                //给客户端反馈信息
                DataOutputStream out = new DataOutputStream(server.getOutputStream());
                out.writeUTF("文件接受成功");

                out.close();
                buff.close();
                print.close();
                server.close();
            }catch(SocketTimeoutException s)
            {
                System.out.println("Socket timed out!");
                break;
            }catch(IOException e)
            {
                e.printStackTrace();
                break;
            }
        }
    }
    public static void main(String [] args)
    {
        int port = Integer.parseInt(args[0]);
        try
        {
            Thread t = new GreetingServer(port);
            t.run();
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}