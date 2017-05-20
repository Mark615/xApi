package de.mark615.xapi.interfaces;

import org.bukkit.entity.Player;

public interface XSignInApiInterface
{
	public boolean resetPlayer(Player sender, Player target);
	
	public boolean setPlayerPassword(Player sender, Player target, String password);
	
	public boolean loginPlayer(Player sender, Player target, String password);
	
	public boolean isPlayerLoggedIn(Player sender, Player target);
}
