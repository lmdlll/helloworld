package edu.greatfree.threetier.coordinator;

import java.util.Calendar;

import org.greatfree.client.OutMessageStream;
import org.greatfree.concurrency.interactive.NotificationDispatcher;
import org.greatfree.concurrency.interactive.RequestDispatcher;
import org.greatfree.data.ServerConfig;
import org.greatfree.message.ServerMessage;
import org.greatfree.server.ServerDispatcher;

import edu.greatfree.threetier.message.CPSMessageType;
import edu.greatfree.threetier.message.FrontNotification;
import edu.greatfree.threetier.message.FrontRequest;
import edu.greatfree.threetier.message.FrontResponse;
import edu.greatfree.threetier.message.FrontStream;

// Created: 07/06/2018, Bing Li
class CoordinatorDispatcher extends ServerDispatcher<ServerMessage>
{
	private NotificationDispatcher<FrontNotification, FrontNotificationThread, FrontNotificationThreadCreator> frontNotificationDispatcher;
	private RequestDispatcher<FrontRequest, FrontStream, FrontResponse, FrontRequestThread, FrontRequestThreadCreator> frontRequestDispatcher;

//	public CoordinatorDispatcher(int schedulerPoolSize, long schedulerKeepAliveTime)
	public CoordinatorDispatcher(int threadPoolSize, long threadKeepAliveTime, int schedulerPoolSize, long schedulerKeepAliveTime)
	{
		super(threadPoolSize, threadKeepAliveTime, schedulerPoolSize, schedulerKeepAliveTime);

		// Initialize the notification dispatcher for the notification, FrontNotification
		this.frontNotificationDispatcher = new NotificationDispatcher.NotificationDispatcherBuilder<FrontNotification, FrontNotificationThread, FrontNotificationThreadCreator>()
				.poolSize(ServerConfig.NOTIFICATION_DISPATCHER_POOL_SIZE)
				.threadCreator(new FrontNotificationThreadCreator())
				.notificationQueueSize(ServerConfig.NOTIFICATION_QUEUE_SIZE)
				.dispatcherWaitTime(ServerConfig.NOTIFICATION_DISPATCHER_WAIT_TIME)
				.waitRound(ServerConfig.NOTIFICATION_DISPATCHER_WAIT_ROUND)
				.idleCheckDelay(ServerConfig.NOTIFICATION_DISPATCHER_IDLE_CHECK_DELAY)
				.idleCheckPeriod(ServerConfig.NOTIFICATION_DISPATCHER_IDLE_CHECK_PERIOD)
				.scheduler(super.getScheduler())
				.build();

		// Initialize the request dispatcher for the request/response, FrontRequest/FrontResponse
		this.frontRequestDispatcher = new RequestDispatcher.RequestDispatcherBuilder<FrontRequest, FrontStream, FrontResponse, FrontRequestThread, FrontRequestThreadCreator>()
				.poolSize(ServerConfig.REQUEST_DISPATCHER_POOL_SIZE)
				.threadCreator(new FrontRequestThreadCreator())
				.requestQueueSize(ServerConfig.REQUEST_QUEUE_SIZE)
				.dispatcherWaitTime(ServerConfig.REQUEST_DISPATCHER_WAIT_TIME)
				.waitRound(ServerConfig.REQUEST_DISPATCHER_WAIT_ROUND)
				.idleCheckDelay(ServerConfig.REQUEST_DISPATCHER_IDLE_CHECK_DELAY)
				.idleCheckPeriod(ServerConfig.REQUEST_DISPATCHER_IDLE_CHECK_PERIOD)
				.scheduler(super.getScheduler())
				.build();
	}

	@Override
	public void dispose(long timeout) throws InterruptedException
	{
		this.frontNotificationDispatcher.dispose();
		this.frontRequestDispatcher.dispose();
		super.shutdown(timeout);
	}

	@Override
	public void process(OutMessageStream<ServerMessage> message)
	{
		switch (message.getMessage().getType())
		{
			case CPSMessageType.FRONT_NOTIFICATION:
				System.out.println("FRONT_NOTIFICATION received @" + Calendar.getInstance().getTime());
				// Check whether the adding friends notification dispatcher is ready or not. 02/15/2016, Bing Li
				if (!this.frontNotificationDispatcher.isReady())
				{
					// Execute the notification dispatcher concurrently. 02/15/2016, Bing Li
					super.execute(this.frontNotificationDispatcher);
				}
				// Enqueue the instance of FrontNotification into the dispatcher for concurrent processing. 02/15/2016, Bing Li
				this.frontNotificationDispatcher.enqueue((FrontNotification)message.getMessage());
				break;

			case CPSMessageType.FRONT_REQUEST:
				System.out.println("FRONT_REQUEST received @" + Calendar.getInstance().getTime());
				// Check whether the registry dispatcher is ready. 04/17/2017, Bing Li
				if (!this.frontRequestDispatcher.isReady())
				{
					// Execute the registry dispatcher as a thread. 04/17/2017, Bing Li
					super.execute(this.frontRequestDispatcher);
				}
				// Enqueue the request into the dispatcher for concurrent responding. 04/17/2017, Bing Li
				this.frontRequestDispatcher.enqueue(new FrontStream(message.getOutStream(), message.getLock(), (FrontRequest)message.getMessage()));
				break;
		}
	}

}
