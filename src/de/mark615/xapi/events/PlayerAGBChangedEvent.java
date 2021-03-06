package de.mark615.xapi.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerAGBChangedEvent extends Event
{
	private static final HandlerList handlers = new HandlerList();
	private Player player;
	private boolean value;
	
	public PlayerAGBChangedEvent(Player p, boolean value)
	{
		this.player = p;
		this.value = value;
	}
	
	public Player getPlayer()
	{
		return this.player;
	}

	public HandlerList getHandlers()
	{
		return handlers;
	}

	public static HandlerList getHandlerList()
	{
		return handlers;
	}

	public boolean hasAcceptAGB()
	{
		return value;
	}
}
