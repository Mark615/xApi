package de.mark615.xapi.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class MaintenanceSwitchEvent extends Event
{
	private static final HandlerList handlers = new HandlerList();
	private boolean value;
	
	public MaintenanceSwitchEvent(boolean value)
	{
		this.value = value;
	}
	
	public boolean getNewMaintenanceMode()
	{
		return this.value;
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
