package edu.greatfree.p2p.peer;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;

import edu.greatfree.p2p.message.ChatOptions;
import edu.greatfree.p2p.message.SendNotification;
import org.greatfree.chat.ChatMenu;

/*
 * The class aims to print a menu list on the screen for users to interact with the client and chat with the chatting peer. The menu is unique in the client such that it is implemented in the pattern of a singleton. 04/27/2017, Bing Li
 */

// Created: 05/02/2017, Bing Li
class ChatUI
{
	private Scanner in = new Scanner(System.in);

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
			case ChatOptions.SEND_FILE:
				System.out.println("filePath");
				String filePath = in.nextLine();
				System.out.println("fileName");
				String filename = in.nextLine();
//				String fiilName ="E:\\"+"abc.PNG";

				InputStream inputStream = null;
//				File file = new File(fiilName);
				File file = new File(filePath+File.separator+filename);
				byte[] bytes = new byte[(int)file.length()];
				try {
					inputStream = new FileInputStream(file);
					inputStream.read(bytes);
					ChatPeer.PEER().notifyFile(ChatMaintainer.PEER().getPartnerIP(), ChatMaintainer.PEER().getPartnerPort(), filePath,filename,bytes);

				} catch (Exception e) {
					e.printStackTrace();
				}
				break;

			case ChatOptions.QUIT_CHAT:
				break;
		}
	}
}
