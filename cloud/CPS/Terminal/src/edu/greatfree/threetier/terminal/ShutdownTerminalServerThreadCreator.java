package edu.greatfree.threetier.terminal;

import org.greatfree.chat.message.ShutdownServerNotification;
import org.greatfree.concurrency.interactive.NotificationThreadCreatable;

// Created: 07/07/2018, Bing Li
class ShutdownTerminalServerThreadCreator implements NotificationThreadCreatable<ShutdownServerNotification, ShutdownTerminalServerThread>
{

	@Override
	public ShutdownTerminalServerThread createNotificationThreadInstance(int taskSize)
	{
		return new ShutdownTerminalServerThread(taskSize);
	}

}
