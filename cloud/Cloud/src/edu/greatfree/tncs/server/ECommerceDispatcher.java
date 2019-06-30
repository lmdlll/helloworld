package edu.greatfree.tncs.server;

import java.util.Calendar;

import org.greatfree.client.OutMessageStream;
import org.greatfree.concurrency.interactive.RequestDispatcher;
import org.greatfree.message.ServerMessage;
import org.greatfree.server.ServerDispatcher;

import edu.greatfree.tncs.message.MerchandiseRequest;
import edu.greatfree.tncs.message.MerchandiseResponse;
import edu.greatfree.tncs.message.MerchandiseStream;
import edu.greatfree.tncs.message.MessageType;

// Created: 05/01/2019, Bing Li
class ECommerceDispatcher extends ServerDispatcher<ServerMessage>
{
	private RequestDispatcher<MerchandiseRequest, MerchandiseStream, MerchandiseResponse, MerchandiseRequestThread, MerchandiseRequestThreadCreator> merchandiseDispatcher;

	public ECommerceDispatcher(int serverThreadPoolSize, long serverThreadKeepAliveTime, int schedulerPoolSize, long schedulerKeepAliveTime)
	{
		super(serverThreadPoolSize, serverThreadKeepAliveTime, schedulerPoolSize, schedulerKeepAliveTime);

		this.merchandiseDispatcher = new RequestDispatcher.RequestDispatcherBuilder<MerchandiseRequest, MerchandiseStream, MerchandiseResponse, MerchandiseRequestThread, MerchandiseRequestThreadCreator>()
				.poolSize(ServerConfig.REQUEST_DISPATCHER_POOL_SIZE)
				.threadCreator(new MerchandiseRequestThreadCreator())
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
		this.merchandiseDispatcher.dispose();
		super.shutdown(timeout);
	}

	@Override
	public void process(OutMessageStream<ServerMessage> message)
	{
		switch (message.getMessage().getType())
		{
			case MessageType.MERCHANDISE_REQUEST:
				System.out.println("MERCHANDISE_REQUEST received @" + Calendar.getInstance().getTime());
				if (!this.merchandiseDispatcher.isReady())
				{
					super.execute(this.merchandiseDispatcher);
				}
				this.merchandiseDispatcher.enqueue(new MerchandiseStream(message.getOutStream(), message.getLock(), (MerchandiseRequest)message.getMessage()));
				break;
		}
	}
}
