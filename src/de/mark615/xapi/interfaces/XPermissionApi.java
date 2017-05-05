package de.mark615.xapi.interfaces;

import org.bukkit.entity.Player;

import de.mark615.xapi.PriorityConfigBase;
import de.mark615.xapi.XApi;
import de.mark615.xapi.events.PlayerFirstjoinEvent;
import de.mark615.xapi.events.PlayerRankChangedEvent;

public abstract class XPermissionApi implements XPermissionApiInterface
{
	private XApi plugin;
	private PriorityConfigBase priorityBase;
	
	public XPermissionApi(XApi plugin)
	{
		this.plugin = plugin;
		this.priorityBase = plugin.getPriorityConfig();
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
	
}
