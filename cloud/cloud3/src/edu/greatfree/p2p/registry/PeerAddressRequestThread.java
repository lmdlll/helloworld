package edu.greatfree.p2p.registry;

import java.io.IOException;

import org.greatfree.concurrency.interactive.RequestQueue;
import org.greatfree.data.ServerConfig;
import org.greatfree.dip.multicast.message.PeerAddressRequest;
import org.greatfree.dip.multicast.message.PeerAddressResponse;
import org.greatfree.dip.multicast.message.PeerAddressStream;
import org.greatfree.server.PeerRegistry;

// Created: 09/11/2018, Bing Li
class PeerAddressRequestThread extends RequestQueue<PeerAddressRequest, PeerAddressStream, PeerAddressResponse>
{

	public PeerAddressRequestThread(int maxTaskSize)
	{
		super(maxTaskSize);
	}

	@Override
	public void run()
	{
		PeerAddressStream request;
		PeerAddressResponse response;
		while (!this.isShutdown())
		{
			while (!this.isEmpty())
			{
				request = this.getRequest();
				System.out.println("PeerAddressRequestThread peer ID = " + request.getMessage().getPeerID());
				response = new PeerAddressResponse(PeerRegistry.SYSTEM().getAddress(request.getMessage().getPeerID()));
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
				this.holdOn(ServerConfig.REQUEST_THREAD_WAIT_TIME);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		
	}

}
