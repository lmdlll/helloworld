package edu.greatfree.p2p.peer;

import java.awt.*;
import java.io.*;
import java.util.Scanner;

import edu.greatfree.cs.multinode.ChatMenu;
import edu.greatfree.cs.multinode.ChatOptions;
import edu.greatfree.p2p.message.Openpicture;
import edu.greatfree.p2p.message.SendImageFileNotification;
import edu.greatfree.p2p.message.sendpicture;

import javax.swing.*;

/*
 * The class aims to print a menu list on the screen for users to interact with the client and chat with the chatting peer. The menu is unique in the client such that it is implemented in the pattern of a singleton. 04/27/2017, Bing Li
 */

// Created: 05/02/2017, Bing Li
class ChatUI
{
	private Scanner in = new Scanner(System.in);
	//C:\Users\acer\Desktop
	private String soupath = "C:"+File.separator+"Users"+File.separator+"acer"+File.separator+"Desktop"+File.separator+"yun.jpg";
	private String despath = "C:"+File.separator+"Users"+File.separator+"acer"+File.separator+"Desktop"+File.separator+"yun1.jpg";

	/*
	 * Initialize. 04/27/2017, Bing Li
	 */
	private ChatUI()
	{
	}

	/*
	 * Initialize a singleton. 04/23/2017, Bing Li
	 */
	private static ChatUI instance = new ChatUI();
	
	public static ChatUI PEER()
	{
		if (instance == null)
		{
			instance = new ChatUI();
			return instance;
		}
		else
		{
			return instance;
		}
	}
	
	public void dispose()
	{
		this.in.close();
	}

	/*
	 * Print the menu list on the screen. 04/23/2017, Bing Li
	 */
	public void printMenu()
	{
		System.out.println(ChatMenu.MENU_HEAD);
		System.out.println(ChatMenu.TYPE_MESSAGE + ChatMaintainer.PEER().getPartner());
		System.out.println(ChatMenu.SEND_PICTURE);
		System.out.println(ChatMenu.QUIT);
		System.out.println(ChatMenu.MENU_TAIL);
		System.out.println(ChatMenu.INPUT_PROMPT);
	}

	/*
	 * Send messages to the chatting peer. 04/23/2017, Bing Li
	 */
	public void sent(int option)
	{
		switch (option)
		{
			// Send the chatting message to the chatting partner. 06/11/2017, Bing Li
			case ChatOptions.TYPE_CHAT:
				System.out.println("Please type your message: ");
				String message = in.nextLine();
				ChatPeer.PEER().notifyChat(ChatMaintainer.PEER().getPartnerIP(), ChatMaintainer.PEER().getPartnerPort(), message);
				break;

			case ChatOptions.QUIT_CHAT:
				break;

			//发送图片
			// TODO:
			case ChatOptions.SEND_PICTURE:
				String fiilName =null;
//				System.out.println("Send your picture: ");
//				String str;
//				try {
//					boolean result = sendpicture.copyFile(soupath,despath);
//					if(result==true){
//						str="发送成功";
//					}else{
//						str="发送失败";
//					}
//					ChatPeer.PEER().notifyChat(ChatMaintainer.PEER().getPartnerIP(), ChatMaintainer.PEER().getPartnerPort(), str);
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
				InputStream inputStream = null;
				File file = new File(fiilName);
				byte[] bytes = new byte[(int)file.length()];
				try {
					inputStream = new FileInputStream(file);
					ChatPeer.PEER().notifyImage(ChatMaintainer.PEER().getPartnerIP(), ChatMaintainer.PEER().getPartnerPort(), bytes);

					inputStream.read(bytes);
				} catch (Exception e) {
					e.printStackTrace();
				}

				break;

			//接收图片 暂时去掉，没有意义
			case ChatOptions.RECEIVE_PICTURE:
				System.out.println("Receive pictures: ");
				String res;
				//这里加一个判断条件，接收一个消息，为true则显示图片并且向发送端发送发送成功
				if(true) {
					EventQueue.invokeLater(() -> {
						JFrame frame = new Openpicture();
//                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						frame.setVisible(true);
					});
					res="接收成功";
					ChatPeer.PEER().notifyChat(ChatMaintainer.PEER().getPartnerIP(), ChatMaintainer.PEER().getPartnerPort(), res);

				}else{
					res="接收失败";
					ChatPeer.PEER().notifyChat(ChatMaintainer.PEER().getPartnerIP(), ChatMaintainer.PEER().getPartnerPort(), res);
				}

				break;
		}
	}
}
