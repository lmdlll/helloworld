package edu.greatfree.cs.multinode.server;

import java.util.Calendar;

import org.greatfree.client.OutMessageStream;
import org.greatfree.concurrency.interactive.NotificationDispatcher;
import org.greatfree.data.ServerConfig;
import org.greatfree.message.ServerMessage;
import org.greatfree.server.ServerDispatcher;

import edu.greatfree.cs.multinode.message.ChatMessageType;
import edu.greatfree.cs.multinode.message.ShutdownServerNotification;

/*
 * The server dispatcher extends com.greatfree.server.ServerDispatcher to implement a sub server dispatcher for administration. 04/15/2017, Bing Li
 */

// Created: 04/20/2017, Bing Li
class ChatManServerDispatcher extends ServerDispatcher<ServerMessage>
{
	// Declare a notification dispatcher to shutdown the server when such a notification is received. 04/18/2016, Bing Li
	private NotificationDispatcher<ShutdownServerNotification, ShutdownChattingServerThread, ShutdownChattingServerThreadCreator> shutdownNotificationDispatcher;

	public ChatManServerDispatcher(int threadPoolSize, long threadKeepAliveTime, int schedulerPoolSize, long schedulerKeepAliveTime)
	{
		super(threadPoolSize, threadKeepAliveTime, schedulerPoolSize, schedulerKeepAliveTime);

		this.shutdownNotificationDispatcher = new NotificationDispatcher.NotificationDispatcherBuilder<ShutdownServerNotification, ShutdownChattingServerThread, ShutdownChattingServerThreadCreator>()
				.poolSize(ServerConfig.NOTIFICATION_DISPATCHER_POOL_SIZE)
				.threadCreator(new ShutdownChattingServerThreadCreator())
				.notificationQueueSize(ServerConfig.NOTIFICATION_QUEUE_SIZE)
				.dispatcherWaitTime(ServerConfig.NOTIFICATION_DISPATCHER_WAIT_TIME)
				.waitRound(ServerConfig.NOTIFICATION_DISPATCHER_WAIT_ROUND)
				.idleCheckDelay(ServerConfig.NOTIFICATION_DISPATCHER_IDLE_CHECK_DELAY)
				.idleCheckPeriod(ServerConfig.NOTIFICATION_DISPATCHER_IDLE_CHECK_PERIOD)
				.scheduler(super.getScheduler())
				.build();
	}

	/*
	 * Shut down the server message dispatcher. 04/15/2017, Bing Li
	 */
	@Override
	public void dispose(long timeout) throws InterruptedException
	{
		this.shutdownNotificationDispatcher.dispose();
		super.shutdown(timeout);
	}

	/*
	 * Process the available messages in a concurrent way. 04/17/2017, Bing Li
	 */
	@Override
	public void process(OutMessageStream<ServerMessage> message)
	{
		// Check the types of received messages. 04/17/2017, Bing Li
		switch (message.getMessage().getType())
		{	
			case ChatMessageType.SHUTDOWN_SERVER_NOTIFICATION:
				System.out.println("SHUTDOWN_CHAT_SERVER_NOTIFICATION received @" + Calendar.getInstance().getTime());
				// Check whether the shutdown notification dispatcher is ready or not. 02/15/2016, Bing Li
				if (!this.shutdownNotificationDispatcher.isReady())
				{
					// Execute the notification dispatcher concurrently. 02/15/2016, Bing Li
					super.execute(this.shutdownNotificationDispatcher);
				}
				// Enqueue the instance of ShutdownChatServerNotification into the dispatcher for concurrent processing. 02/15/2016, Bing Li
				this.shutdownNotificationDispatcher.enqueue((ShutdownServerNotification)message.getMessage());
				break;
		}
	}
}
