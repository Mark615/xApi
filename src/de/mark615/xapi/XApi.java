package de.mark615.xapi;

import java.util.HashMap;

import org.bukkit.plugin.java.JavaPlugin;

import de.mark615.xapi.interfaces.XPermissionApi;
import de.mark615.xapi.interfaces.XPlugin;
import de.mark615.xapi.interfaces.XSignInApi;
import de.mark615.xapi.versioncheck.VersionCheck;
import de.mark615.xapi.versioncheck.VersionCheck.XType;

public class XApi extends JavaPlugin
{
	public static final int BUILD = 3;
	private static XApi instance;
	
	private HashMap<XType, XPlugin> xpluginlist;
	
	private PriorityConfig priority;
	private SettingManager settings;
	
	
	@Override
	public void onDisable()
	{
		xpluginlist.clear();
	}

	@Override
	public void onEnable()
	{
		instance = this;
		xpluginlist = new HashMap<>();
		settings = new SettingManager(this);
		priority = new PriorityConfig(settings);
		
		System.out.println("[xApi] started");
		
		//ExampleListener listener = new ExampleListener(this);
	}
	
	public XApi getInstance()
	{
		return instance;
	}
	
	public boolean checkVersion(XType type, int version)
	{
		return VersionCheck.isSupported(type, version);
	}
	
	
	
	public PriorityConfigBase getPriorityConfig()
	{
		return priority;
	}
	
	public void registerXPermission(XPermissionApi api)
	{
		xpluginlist.put(XType.xPermission, api);
		priority.registerXPermission();
	}
	
	public void registerXSignIn(XSignInApi api)
	{
		xpluginlist.put(XType.xSignIn, api);
		priority.registerXSignIn();
	}
	
	public XPlugin getXPlugin(XType type)
	{
		return xpluginlist.get(type);
	}

}
