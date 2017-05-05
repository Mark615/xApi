package de.mark615.xapi;

import org.bukkit.plugin.java.JavaPlugin;

import de.mark615.xapi.events.TestListener;
import de.mark615.xapi.interfaces.XPermissionApi;

public class XApi extends JavaPlugin
{
	private static XApi instance;
	
	private XPermissionApi permApi;
	
	private PriorityConfig priority;
	private SettingManager settings;
	
	
	@Override
	public void onDisable()
	{
		permApi = null;
	}

	@Override
	public void onEnable()
	{
		instance = this;
		settings = new SettingManager(this);
		priority = new PriorityConfig(settings);
		
		TestListener listener = new TestListener(this);
	}
	
	public XApi getInstance()
	{
		return instance;
	}
	
	public PriorityConfigBase getPriorityConfig()
	{
		return priority;
	}
	
	public void registerXPermission(XPermissionApi api)
	{
		permApi = api;
		priority.registerXPermission();
	}
	
	public XPermissionApi getXPermissionApi()
	{
		return permApi;
	}

}
