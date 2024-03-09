package org.gulingjingguai.mzp.lesson.runoob.advancedStage;

import java.net.*;
import java.io.*;

public class GreetingServer extends Thread
{
    private ServerSocket serverSocket;

    public GreetingServer(int port) throws IOException
    {
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(100000);
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
                DataInputStream in = new DataInputStream(server.getInputStream());
                System.out.println(in.readUTF());
                //给客户端反馈信息
                DataOutputStream out = new DataOutputStream(server.getOutputStream());
                out.writeUTF("已读");
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