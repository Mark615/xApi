package de.mark615.xapi.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerPasswordResetEvent extends Event
{
	private static final HandlerList handlers = new HandlerList();
	private Player player;
	
	public PlayerPasswordResetEvent(Player p)
	{
		this.player = p;
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
}
