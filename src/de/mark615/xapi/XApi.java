package de.mark615.xapi;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import de.mark615.xapi.events.ServerLoadedEvent;
import de.mark615.xapi.interfaces.XBanApi;
import de.mark615.xapi.interfaces.XChatApi;
import de.mark615.xapi.interfaces.XPermissionApi;
import de.mark615.xapi.interfaces.XPlugin;
import de.mark615.xapi.interfaces.XSignInApi;
import de.mark615.xapi.object.Updater;
import de.mark615.xapi.object.Updater.UpdateResult;
import de.mark615.xapi.object.Updater.UpdateType;
import de.mark615.xapi.object.XUtil;
import de.mark615.xapi.versioncheck.VersionCheck;
import de.mark615.xapi.versioncheck.VersionCheck.XType;

public class XApi extends JavaPlugin
{
	public static final int BUILD = 5;
	public static String PLUGIN_NAME = "[xApi] ";
	private static XApi instance;
	
	private HashMap<XType, XPlugin> xpluginlist;
	
	private PriorityConfig priority;
	private SettingManager settings;
	
	@Override
	public void onDisable()
	{
		XUtil.onDisable();
		xpluginlist.clear();
	}

	@Override
	public void onEnable()
	{
		instance = this;
		xpluginlist = new HashMap<>();
		settings = SettingManager.getInstance();
		settings.setup(this);
		priority = new PriorityConfig(settings);
		
		
		Bukkit.getServer().getScheduler().runTaskLater(this, new Runnable() {
			
			@Override
			public void run()
			{
				ServerLoadedEvent event = new ServerLoadedEvent();
				getServer().getPluginManager().callEvent(event);
			}
		}, 1);
		
		XUtil.onEnable();
		updateCheck();
		
		//ExampleListener listener = new ExampleListener(this);
	}
	
	private void updateCheck()
	{
		if (SettingManager.getInstance().hasCheckVersion())
		{
			try
			{
				Updater updater = new Updater(this, 267925, this.getFile(), UpdateType.NO_DOWNLOAD, true);
				if (updater.getResult() == UpdateResult.UPDATE_AVAILABLE) {
				    XUtil.info("New version available! " + updater.getLatestName());
				}
			}
			catch(Exception e)
			{
				XUtil.severe("Can't generate checkUpdate webrequest");
			}
		}
	}
	
	public static XApi getInstance()
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
	
	public void registerXChat(XChatApi api)
	{
		xpluginlist.put(XType.xChat, api);
		priority.registerXChat();
	}
	
	public void registerXBan(XBanApi api)
	{
		xpluginlist.put(XType.xBan, api);
		priority.registerXBan();
	}
	
	public XPlugin getXPlugin(XType type)
	{
		return xpluginlist.get(type);
	}

}
