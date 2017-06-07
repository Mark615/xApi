package de.mark615.xapi.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class ServerLoadedEvent extends Event
{
	private static final HandlerList handlers = new HandlerList();
	
	public ServerLoadedEvent()
	{
		
	}
		
	public HandlerList getHandlers()
	{
		return handlers;
	}

	public static HandlerList getHandlerList()
	{
		return handlers;
	}
}
