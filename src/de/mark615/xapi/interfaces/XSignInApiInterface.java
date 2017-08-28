package de.mark615.xapi.interfaces;

import java.util.List;
import java.util.UUID;

import org.bukkit.entity.Player;

public interface XSignInApiInterface
{
	public boolean resetPlayer(Player sender, Player target);
	
	public boolean setPlayerPassword(Player sender, Player target, String password);
	
	public boolean loginPlayer(Player sender, Player target, String password);
	
	public boolean isPlayerLoggedIn(Player sender, Player target);
	
	
	public boolean isMaintenanceMode();
	
	public boolean setMaintenanceMode(boolean value);
	
	
	public void setAGB(boolean value);
	
	public List<String> getAGB();
	
	
	public void setWhitelist(boolean value);
	
	public boolean isWhitelist();
	
	public void setBlacklist(boolean value);
	
	public boolean isBlacklist();
	
	public boolean addElementToWhitelist(String value, String type);

	public boolean removeElementToWhitelist(String value, String type);
	
	public boolean addElementToBlacklist(String value, String type);

	public boolean removeElementToBlacklist(String value, String type);

	
	public UUID getUUIDfromIP(String ip);
	
	public String getNamefromIP(String ip);
}
