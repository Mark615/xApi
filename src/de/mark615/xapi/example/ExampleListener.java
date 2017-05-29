package de.mark615.xapi.example;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import de.mark615.xapi.XApi;
import de.mark615.xapi.events.PlayerFirstjoinEvent;
import de.mark615.xapi.events.PlayerRankChangedEvent;

public class ExampleListener implements Listener
{
	private XApi plugin;
	
	public ExampleListener(XApi plugin)
	{
		this.plugin = plugin;
		this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onPlayerFirstjoinEvent(PlayerFirstjoinEvent event)
	{
		System.out.println("[TEST] player has joined the first time: " + event.getPlayer().getName());
	}
	
	@EventHandler
	public void onPlayerRankChangedEvent(PlayerRankChangedEvent event)
	{
		System.out.println("[TEST] player rank has changed: " + event.getPlayer().getName());
	}
}
