package edu.greatfree.tncs.client;

import java.io.IOException;
import java.util.Scanner;

import org.greatfree.exceptions.RemoteReadException;

import edu.greatfree.tncs.message.MerchandiseResponse;

// Created: 05/01/2019, Bing Li
class StartClient
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Press Enter to start ...");
		in.nextLine();
		try
		{
			MerchandiseResponse response = ECommerceReader.CS().read("GF-01-12345");
			System.out.println("ID = " + response.getMerchandiseID());
			System.out.println("Name = " + response.getMerchandiseName());
			System.out.println("Description = " + response.getDescription());
			System.out.println("Price = " + response.getPrice());
			System.out.println("In Stock = " + response.getInStock());
			System.out.println("Manufacturer = " + response.getManufacturer());
			System.out.println("Shipping Manner = " + response.getShippingManner());
		}
		catch (ClassNotFoundException | RemoteReadException | IOException e)
		{
			e.printStackTrace();
		}
		System.out.println("Press Enter to exit ...");
		in.nextLine();
		in.close();
	}
}
