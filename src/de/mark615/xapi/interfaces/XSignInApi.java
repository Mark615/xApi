package de.mark615.xapi.interfaces;

import org.bukkit.entity.Player;

import de.mark615.xapi.XApi;
import de.mark615.xapi.events.BlacklistStateChangedEvent;
import de.mark615.xapi.events.ElementAddedToBlacklistEvent;
import de.mark615.xapi.events.ElementAddedToWhitelistEvent;
import de.mark615.xapi.events.ElementRemovedFromBlacklistEvent;
import de.mark615.xapi.events.ElementRemovedFromWhitelistEvent;
import de.mark615.xapi.events.MaintenanceSwitchEvent;
import de.mark615.xapi.events.PlayerAGBChangedEvent;
import de.mark615.xapi.events.PlayerFirstjoinEvent;
import de.mark615.xapi.events.PlayerLoggedInEvent;
import de.mark615.xapi.events.PlayerPasswordChangedEvent;
import de.mark615.xapi.events.PlayerPasswordResetEvent;
import de.mark615.xapi.events.WhitelistStateChangedEvent;

public abstract class XSignInApi extends XPlugin implements XSignInApiInterface
{
	public XSignInApi(XApi plugin)
	{
		super(plugin);
	}
	
	public void createPlayerFirstJoinEvent(Player p)
	{
		PlayerFirstjoinEvent event = new PlayerFirstjoinEvent(p);
		plugin.getServer().getPluginManager().callEvent(event);
	}
	
	public void createPlayerPasswordChangedEvent(Player p)
	{
		PlayerPasswordChangedEvent event = new PlayerPasswordChangedEvent(p);
		plugin.getServer().getPluginManager().callEvent(event);
	}
	
	public void createPlayerResetEvent(Player p)
	{
		PlayerPasswordResetEvent event = new PlayerPasswordResetEvent(p);
		plugin.getServer().getPluginManager().callEvent(event);
	}
	
	public void createPlayerLoggedInEvent(Player p)
	{
		PlayerLoggedInEvent event = new PlayerLoggedInEvent(p);
		plugin.getServer().getPluginManager().callEvent(event);
	}
	
	public void createMaintenanceModeSwitchEvent(boolean value)
	{
		MaintenanceSwitchEvent event = new MaintenanceSwitchEvent(value);
		plugin.getServer().getPluginManager().callEvent(event);
	}
	
	public void createPlayerAGBEvent(Player p, boolean value)
	{
		PlayerAGBChangedEvent event = new PlayerAGBChangedEvent(p, value);
		plugin.getServer().getPluginManager().callEvent(event);
	}
	
	public void createElementAddedToWhitelist(String value, String type)
	{
		ElementAddedToWhitelistEvent event = new ElementAddedToWhitelistEvent(value, type);
		plugin.getServer().getPluginManager().callEvent(event);
	}
	
	public void createElementRemovedToWhitelist(String value, String type)
	{
		ElementRemovedFromWhitelistEvent event = new ElementRemovedFromWhitelistEvent(value, type);
		plugin.getServer().getPluginManager().callEvent(event);
	}
	
	public void createElementAddedToBlacklist(String value, String type)
	{
		ElementAddedToBlacklistEvent event = new ElementAddedToBlacklistEvent(value, type);
		plugin.getServer().getPluginManager().callEvent(event);
	}
	
	public void createElementRemovedToBlacklist(String value, String type)
	{
		ElementRemovedFromBlacklistEvent event = new ElementRemovedFromBlacklistEvent(value, type);
		plugin.getServer().getPluginManager().callEvent(event);
	}
	
	public void createWhitelistChangedStateEvent(boolean value)
	{
		WhitelistStateChangedEvent event = new WhitelistStateChangedEvent(value);
		plugin.getServer().getPluginManager().callEvent(event);
	}
	
	public void createBlacklistChangedStateEvent(boolean value)
	{
		BlacklistStateChangedEvent event = new BlacklistStateChangedEvent(value);
		plugin.getServer().getPluginManager().callEvent(event);
	}
	
}
