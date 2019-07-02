package edu.greatfree.p2p.peer;

import edu.greatfree.p2p.message.MesgNotification;
import org.greatfree.concurrency.interactive.NotificationThreadCreatable;

import edu.greatfree.p2p.message.ChatNotification;

// Created: 05/02/2017, Bing Li
class ChatThreadCreator implements NotificationThreadCreatable<MesgNotification,  ChatThread>
{

	@Override
	public ChatThread createNotificationThreadInstance(int taskSize)
	{
		return new ChatThread(taskSize);
	}

}
