package edu.greatfree.cs.multinode.server;

import java.io.IOException;

import org.greatfree.concurrency.interactive.RequestQueue;
import org.greatfree.data.ServerConfig;
import org.greatfree.dip.cs.multinode.server.CSAccount;
import org.greatfree.dip.cs.twonode.server.AccountRegistry;
import org.greatfree.util.UtilConfig;

import edu.greatfree.cs.multinode.message.ChatPartnerRequest;
import edu.greatfree.cs.multinode.message.ChatPartnerResponse;
import edu.greatfree.cs.multinode.message.ChatPartnerStream;

/*
 * The thread checks the retrieved user of chatting. 04/16/2017, Bing Li
 */

// Created: 04/16/2017, Bing Li
class ChatPartnerRequestThread extends RequestQueue<ChatPartnerRequest, ChatPartnerStream, ChatPartnerResponse>
{

	public ChatPartnerRequestThread(int maxTaskSize)
	{
		super(maxTaskSize);
	}

	@Override
	public void run()
	{
		ChatPartnerStream request;
		ChatPartnerResponse response;
		CSAccount account;
		while (!this.isShutdown())
		{
			while (!this.isEmpty())
			{
				request = this.getRequest();
				
				// Check whether the account is existed or not? Bing Li
				if (AccountRegistry.CS().isAccountExisted(request.getMessage().getUserKey()))
				{
					// Get the account. 04/16/2017, Bing Li
					account = AccountRegistry.CS().getAccount(request.getMessage().getUserKey());
					// Generate the response. 04/16/2017, Bing Li
					response = new ChatPartnerResponse(account.getUserKey(), account.getUserName(), account.getDescription());
				}
				else
				{
					// Generate the response. 04/16/2017, Bing Li
					response = new ChatPartnerResponse(UtilConfig.EMPTY_STRING, UtilConfig.EMPTY_STRING, UtilConfig.EMPTY_STRING);
				}
				
				try
				{
					// Respond to the client. 04/16/2017, Bing Li
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
