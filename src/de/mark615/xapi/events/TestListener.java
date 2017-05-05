package de.mark615.xapi.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import de.mark615.xapi.XApi;

public class TestListener implements Listener
{
	private XApi plugin;
	
	public TestListener(XApi plugin)
	{
		this.plugin = plugin;
		this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onPlayerFirstjoinEvent(PlayerFirstjoinEvent event)
	{
		System.out.println("[TEST] player has joined the first time: " + event.getPlayer().getName());
	}
}
