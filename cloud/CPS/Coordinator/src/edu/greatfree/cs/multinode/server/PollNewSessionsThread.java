package edu.greatfree.cs.multinode.server;

import java.io.IOException;

import org.greatfree.concurrency.interactive.RequestQueue;
import org.greatfree.data.ServerConfig;
import org.greatfree.dip.cs.multinode.server.PrivateChatSessions;

import edu.greatfree.cs.multinode.message.PollNewSessionsRequest;
import edu.greatfree.cs.multinode.message.PollNewSessionsResponse;
import edu.greatfree.cs.multinode.message.PollNewSessionsStream;

/*
 * The thread processes PollNewSessionsRequest to ensure whether new sessions are available or not. 04/24/2017, Bing Li
 */

// Created: 04/24/2017, Bing Li
class PollNewSessionsThread extends RequestQueue<PollNewSessionsRequest, PollNewSessionsStream, PollNewSessionsResponse>
{

	public PollNewSessionsThread(int maxTaskSize)
	{
		super(maxTaskSize);
	}

	@Override
	public void run()
	{
		PollNewSessionsStream request;
		PollNewSessionsResponse response;
		while (!this.isShutdown())
		{
			while (!this.isEmpty())
			{
				request = this.getRequest();
				
				if (PrivateChatSessions.HUNGARY().isSessionExisted(request.getMessage().getReceiverKey()))
				{
					// Check whether a new exists. 05/24/2017, Bing Li
					response = new PollNewSessionsResponse(PrivateChatSessions.HUNGARY().getSessionKeys(request.getMessage().getReceiverKey()));
					// The polled session keys should be removed. It is not necessary. It depends on how to design your application. 05/24/2017, Bing Li
					PrivateChatSessions.HUNGARY().removeSession(request.getMessage().getReceiverKey());
				}
				else
				{
					response = new PollNewSessionsResponse(null);
				}
				try
				{
					this.respond(request.getOutStream(), request.getLock(), response);
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
				this.disposeMessage(request, response);
			}
			try
			{
				// Wait for some time when the queue is empty. During the period and before the thread is killed, some new requests might be received. If so, the thread can keep working. 02/15/2016, Bing Li
				this.holdOn(ServerConfig.REQUEST_THREAD_WAIT_TIME);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		
	}

}
