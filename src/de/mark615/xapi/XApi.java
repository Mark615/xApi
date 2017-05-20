package de.mark615.xapi;

import org.bukkit.plugin.java.JavaPlugin;

import de.mark615.xapi.interfaces.XSignInApi;
import de.mark615.xapi.interfaces.XPermissionApi;
import de.mark615.xapi.versioncheck.VersionCheck;
import de.mark615.xapi.versioncheck.VersionCheck.XType;

public class XApi extends JavaPlugin
{
	public static final int BUILD = 2;
	private static XApi instance;
	
	private XPermissionApi permApi;
	private XSignInApi signinApi;
	
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
		permApi = api;
		priority.registerXPermission();
	}
	
	public XPermissionApi getXPermissionApi()
	{
		return permApi;
	}
	
	public void registerXSignIn(XSignInApi api)
	{
		signinApi = api;
		priority.registerXSignIn();
	}
	
	public XSignInApi getXSignInApi()
	{
		return signinApi;
	}

}
