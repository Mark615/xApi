package de.mark615.xapi.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class StateChangedEvent extends Event
{
	private static final HandlerList handlers = new HandlerList();
	protected boolean value;
	
	public StateChangedEvent(boolean value)
	{
		this.value = value;
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
