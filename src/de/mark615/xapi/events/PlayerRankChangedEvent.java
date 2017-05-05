package de.mark615.xapi.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerRankChangedEvent extends Event
{
	private static final HandlerList handlers = new HandlerList();
	private Player player;
	private int prevRank;
	private int rank;
	private boolean auto;
	
	public PlayerRankChangedEvent(Player p, int prevRank, int rank, boolean auto)
	{
		this.player = p;
		this.prevRank = prevRank;
		this.rank = rank;
		this.auto = auto;
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

	public int getPrevRank()
	{
		return prevRank;
	}

	public int getRank()
	{
		return rank;
	}

	public boolean isAuto()
	{
		return auto;
	}
	
}
