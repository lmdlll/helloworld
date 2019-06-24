package edu.greatfree.tncs.message;

import org.greatfree.message.ServerMessage;

// Created: 04/30/2019, Bing Li
public class MerchandiseResponse extends ServerMessage
{
	private static final long serialVersionUID = -3292370275115516847L;

	private String merchandiseID;
	private String merchandiseName;
	private String model;
	private String description;
	private float price;
	private int inStock;
	private String manufacturer;
	private String shippingManner;

	public MerchandiseResponse(String merchandiseID, String merchandiseName, String model, String description, float price, int inStock, String manufacturer, String shippingManner)
	{
		super(MessageType.MERCHANDISE_RESPONSE);
		this.merchandiseID = merchandiseID;
		this.merchandiseName = merchandiseName;
		this.model = model;
		this.description = description;
		this.price = price;
		this.inStock = inStock;
		this.manufacturer = manufacturer;
		this.shippingManner = shippingManner;
	}
	
	public String getMerchandiseID()
	{
		return this.merchandiseID;
	}
	
	public String getMerchandiseName()
	{
		return this.merchandiseName;
	}
	
	public String getModel()
	{
		return this.model;
	}
	
	public String getDescription()
	{
		return this.description;
	}
	
	public float getPrice()
	{
		return this.price;
	}
	
	public int getInStock()
	{
		return this.inStock;
	}
	
	public String getManufacturer()
	{
		return this.manufacturer;
	}
	
	public String getShippingManner()
	{
		return this.shippingManner;
	}
}
