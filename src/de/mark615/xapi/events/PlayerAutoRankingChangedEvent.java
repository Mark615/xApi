package de.mark615.xapi.events;

import org.bukkit.entity.Player;

public class PlayerAutoRankingChangedEvent extends PlayerValueChangedEvent
{
	public PlayerAutoRankingChangedEvent(Player p, boolean value)
	{
		super(p, value);
	}
}
