package com.lmd.Multi;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 多线程版本，客户端。读写分离，读写分别作为一个线程
 */

//读取服务器发来信息的线程
class ReadFromServer implements Runnable{
   private Socket client;
    public ReadFromServer(Socket client) {
        this.client = client;
    }
    @Override
    public void run() {
        Scanner readFromSer = null;
        try {
            while (true) {
                readFromSer = new Scanner(client.getInputStream());
                readFromSer.useDelimiter("\n");
                if (readFromSer.hasNext()) {
                    System.out.println(readFromSer.nextLine());
                }
                if(client.isClosed()){
                    System.out.println("客户端关闭");
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            readFromSer.close();
        }

    }
}



//写线程写信息
class WriteMagToServer implements Runnable{
    private Socket client;
    public WriteMagToServer(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        PrintStream writeMsg = null;
        Scanner in = null;
        try {
            while (true) {
                writeMsg = new PrintStream(client.getOutputStream());
                System.out.println("请输入信息：");
                in = new Scanner(System.in);
                in.useDelimiter("\n");
                if (in.hasNextLine()){
                    writeMsg.println(in.nextLine());
                    if(in.nextLine().equals("byebye")){
                        System.out.println("客户端退出");
                        in.close();
                        writeMsg.close();
                        client.close();
                        break;
                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

public class MultiClient {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("127.0.0.1",8888);
        Thread readThread = new Thread(new ReadFromServer(client));
        Thread writeThread = new Thread(new WriteMagToServer(client));
        readThread.start();
        writeThread.start();
    }
}
