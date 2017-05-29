package de.mark615.xapi.interfaces;

import org.bukkit.entity.Player;

import de.mark615.xapi.PriorityConfigBase;
import de.mark615.xapi.XApi;
import de.mark615.xapi.events.PlayerAutoRankingChangedEvent;
import de.mark615.xapi.events.PlayerFirstjoinEvent;
import de.mark615.xapi.events.PlayerRankChangedEvent;

public abstract class XPermissionApi extends XPlugin implements XPermissionApiInterface
{
	public XPermissionApi(XApi plugin)
	{
		super(plugin);
	}
	
	public void createPlayerFirstjoinEvent(Player p)
	{
		if (priorityBase.canCallEvent(PriorityConfigBase.XPERMISSION, PriorityConfigBase.PLAYERFIRSTJOIN))
		{
			PlayerFirstjoinEvent event = new PlayerFirstjoinEvent(p);
			plugin.getServer().getPluginManager().callEvent(event);
		}
	}
	
	public void createPlayerRankChangedEvent(Player p, int prevrank, int rank, boolean auto)
	{
		if (priorityBase.canCallEvent(PriorityConfigBase.XPERMISSION, PriorityConfigBase.PLAYERRANKCHANGED))
		{
			PlayerRankChangedEvent event = new PlayerRankChangedEvent(p, prevrank, rank, auto);
			plugin.getServer().getPluginManager().callEvent(event);
		}
	}
	
	public void createPlayerAutoRankingChangedEvent(Player p, boolean value)
	{
		if (priorityBase.canCallEvent(PriorityConfigBase.XPERMISSION, PriorityConfigBase.PLAYERAUTORANKINGCHANGED))
		{
			PlayerAutoRankingChangedEvent event = new PlayerAutoRankingChangedEvent(p, value);
			plugin.getServer().getPluginManager().callEvent(event);
		}
	}
	
}
