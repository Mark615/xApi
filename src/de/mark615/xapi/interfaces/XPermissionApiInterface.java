package de.mark615.xapi.interfaces;

import org.bukkit.entity.Player;

public interface XPermissionApiInterface
{
	public void setPlayerRankUp(Player sender, Player target);
	
	public void setPlayerRankDown(Player sender, Player target);
}
