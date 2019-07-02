package edu.greatfree.container.p2p.peer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import edu.greatfree.container.p2p.message.ChatNotification;
import edu.greatfree.container.p2p.message.SendImageFileNotification;
import edu.greatfree.cs.multinode.ChatMenu;
import edu.greatfree.cs.multinode.ChatOptions;
import edu.greatfree.p2p.peer.ChatMaintainer;

// Created: 01/12/2019, Bing Li
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
	
	public static ChatUI CONTAINER()
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
		System.out.println(ChatMenu.SEND_PICTURE + ChatMaintainer.PEER().getPartner());
		System.out.println(ChatMenu.QUIT);
		System.out.println(ChatMenu.MENU_TAIL);
		System.out.println(ChatMenu.INPUT_PROMPT);
	}

	/*
	 * Send messages to the chatting peer. 04/23/2017, Bing Li
	 */
	public void sent(int option) throws IOException, InterruptedException
	{
		switch (option)
		{
			// Send the chatting message to the chatting partner. 06/11/2017, Bing Li
			case ChatOptions.TYPE_CHAT:
				System.out.println("Please type your message: ");
				String message = in.nextLine();
				ChatPeer.Container().notify(ChatMaintainer.PEER().getPartnerIP(), ChatMaintainer.PEER().getPartnerPort(), new ChatNotification(message, ChatMaintainer.PEER().getLocalUsername()));
				break;
			case ChatOptions.SEND_PICTURE:
				System.out.println("PicturePath:");
				String filePath = in.nextLine();
				System.out.println("PictureName:");
				String filename = in.nextLine();
//				String fileName ="E:\\"+"abc.jpg";

				InputStream inputStream = null;
//				File file = new File(fileName);
				File file = new File(filePath+File.separator+filename);
				byte[] bytes = new byte[(int)file.length()];
				try {
					inputStream = new FileInputStream(file);
					inputStream.read(bytes);
					ChatPeer.Container().notify(ChatMaintainer.PEER().getPartnerIP(), ChatMaintainer.PEER().getPartnerPort(),new SendImageFileNotification(bytes,filename));
				} catch (Exception e) {
					e.printStackTrace();
				}

				break;

			case ChatOptions.QUIT_CHAT:
				break;
		}
	}
}
