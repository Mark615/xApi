package de.mark615.xapi.interfaces;

import org.bukkit.entity.Player;

import de.mark615.xapi.PriorityConfigBase;
import de.mark615.xapi.XApi;
import de.mark615.xapi.events.PlayerFirstjoinEvent;
import de.mark615.xapi.events.PlayerLoggedInEvent;
import de.mark615.xapi.events.PlayerPasswordChangedEvent;
import de.mark615.xapi.events.PlayerPasswordResetEvent;

public abstract class XSignInApi extends XPlugin implements XSignInApiInterface
{
	public XSignInApi(XApi plugin)
	{
		super(plugin);
	}
	
	public void createPlayerFirstJoinEvent(Player p)
	{
		if (priorityBase.canCallEvent(PriorityConfigBase.XSIGNIN, PriorityConfigBase.PLAYERFIRSTJOIN))
		{
			PlayerFirstjoinEvent event = new PlayerFirstjoinEvent(p);
			plugin.getServer().getPluginManager().callEvent(event);
		}
	}
	
	public void createPlayerPasswordChangedEvent(Player p)
	{
		if (priorityBase.canCallEvent(PriorityConfigBase.XSIGNIN, PriorityConfigBase.PLAYERPASSWORDCHANGED))
		{
			PlayerPasswordChangedEvent event = new PlayerPasswordChangedEvent(p);
			plugin.getServer().getPluginManager().callEvent(event);
		}
	}
	
	public void createPlayerResetEvent(Player p)
	{
		if (priorityBase.canCallEvent(PriorityConfigBase.XSIGNIN, PriorityConfigBase.PLAYERPASSWORDRESET))
		{
			PlayerPasswordResetEvent event = new PlayerPasswordResetEvent(p);
			plugin.getServer().getPluginManager().callEvent(event);
		}
	}
	
	public void createPlayerLoggedInEvent(Player p)
	{
		if (priorityBase.canCallEvent(PriorityConfigBase.XSIGNIN, PriorityConfigBase.PLAYERLOGGEDIN))
		{
			PlayerLoggedInEvent event = new PlayerLoggedInEvent(p);
			plugin.getServer().getPluginManager().callEvent(event);
		}
	}
}
