package com.lmd.Multi;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MultiServer {
    static Map<String,Socket> map = new HashMap<>();

    static class ExecuteClient implements Runnable{
        private Socket client;
        public ExecuteClient(Socket client) {
            this.client = client;
        }
        @Override
        public void run() {
            Scanner msgFromClient = null;
            try {
                msgFromClient = new Scanner(client.getInputStream());
                while (true){
                    if(msgFromClient.hasNextLine()){
                        String msg = msgFromClient.nextLine();
                        // windows下将默认换行/r/n中的/r替换为空字符串
                        Pattern pattern = Pattern.compile("\r");
                        Matcher matcher = pattern.matcher(msg);
                        msg = matcher.replaceAll("");
                        if(msg.startsWith("userName:")){
                            //注册
                            String userName = msg.split(":")[1];
                            regseterUser(userName,client);
                            continue;
                        }
                        if(msg.startsWith("G:")){
                            //群聊
                            String msgAll = msg.split(":")[1];
                            groupChat(msgAll);
                            continue;
                        }
                        if(msg.startsWith("P:")){
                            //私聊
                            String msgAll = msg.split(":")[1];
                            String userName = msgAll.split("-")[0];
                            String msgp = msgAll.split("-")[1];
                            privateChat(userName,msgp);
                            continue;
                        }
                        if(msg.contains("byebye")){
                            //退出
                            String userName = null;
                            // 根据Socket找到UserName
                            for (String keyName : map.keySet()) {
                                if (map.get(keyName).equals(client)) {
                                    userName = keyName;
                                }
                            }
                            remove(userName);
                            continue;
                        }

                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        //注册
        private void regseterUser(String userName,Socket client){
            PrintStream print = null;
            System.out.println(userName+"上线了");
            map.put(userName, client);
            try {
                print = new PrintStream(client.getOutputStream());
                print.println(userName + "注册成功");
                print.println("当前上线" + map.size() + "人");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //群聊
        private void groupChat(String Msg){
            Set<Map.Entry<String,Socket>> clients = map.entrySet();
            try {
                for(Map.Entry<String,Socket> client :clients){
                    PrintStream print = new PrintStream(client.getValue().getOutputStream());
                    print.println("群聊信息："+Msg);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //私聊
        private void privateChat(String userName,String Msg){
            try {
                PrintStream print = new PrintStream(map.get(userName).getOutputStream());
                    print.println("私聊信息：" + Msg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //退出
        private void remove(String userName) {
            PrintStream print = null;
                map.remove(userName);
                System.out.println(userName + "下线");
                try {
                    print = new PrintStream(client.getOutputStream());
                    print.println(userName + "已下线");
                    print.println("当前在线" + map.size() + "人");
                    print.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

        }

    }


    public static void main(String[] args) {
        ExecutorService execute = Executors.newFixedThreadPool(20);
        try {
            ServerSocket server = new ServerSocket(8888);
            while (true){
                System.out.println("等待客户端连接。。。");
                Socket client = server.accept();
                System.out.println("有新的客户端连接，端口号为："+client.getPort());
                execute.submit(new ExecuteClient(client));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            execute.shutdown();
        }

    }
}
