package de.mark615.xapi.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class ElementAddedToListEvent extends Event
{
	private static final HandlerList handlers = new HandlerList();
	protected String value;
	protected String type;
	
	public ElementAddedToListEvent(String value, String type)
	{
		this.value = value;
		this.type = type;
	}

	public HandlerList getHandlers()
	{
		return handlers;
	}

	public static HandlerList getHandlerList()
	{
		return handlers;
	}
	
	public String getType()
	{
		return type;
	}
	
	public String getValue()
	{
		return value;
	}
}
