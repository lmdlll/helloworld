package edu.greatfree.p2p.peer;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import edu.greatfree.p2p.message.sendpicture;
import org.greatfree.chat.ChatMenu;
import org.greatfree.chat.ChatOptions;

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
			case 2:
				System.out.println("Please send your picture: ");
				String str;
				try {
					boolean result = sendpicture.copyFile(soupath,despath);
					if(result==true){
						str="发送成功";
					}else{
						str="发送失败";
					}
					ChatPeer.PEER().notifyChat(ChatMaintainer.PEER().getPartnerIP(), ChatMaintainer.PEER().getPartnerPort(), str);
				} catch (IOException e) {
					e.printStackTrace();
				}

				break;

			//接收图片
			case 3:
				System.out.println("Receive pictures: ");

				break;
		}
	}
}
