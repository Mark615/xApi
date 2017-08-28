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
import de.mark615.xapi.object.XUtil;
import de.mark615.xapi.versioncheck.VersionCheck;
import de.mark615.xapi.versioncheck.VersionCheck.XType;

public class XApi extends JavaPlugin
{
	public static final int BUILD = 7;
	public static String PLUGIN_NAME = "[xApi] ";
	private static XApi instance;
	
	private HashMap<XType, XPlugin> xpluginlist;
	
	private SettingManager settings;
	private XManagerConnector xmanager;
	
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
		xmanager = new XManagerConnector(this);
		
		
		Bukkit.getServer().getScheduler().runTaskLater(this, new Runnable() {
			
			@Override
			public void run()
			{
				ServerLoadedEvent event = new ServerLoadedEvent();
				getServer().getPluginManager().callEvent(event);
			}
		}, 1);
		
		XUtil.onEnable();
		XUtil.updateCheck(this);
		XUtil.info("Enabled Build " + BUILD);
		//ExampleListener listener = new ExampleListener(this);
	}
	
	public static XApi getInstance()
	{
		return instance;
	}
	
	public boolean checkVersion(XType type, int version)
	{
		return VersionCheck.isSupported(type, version);
	}
	
	
	
	public void registerXPermission(XPermissionApi api)
	{
		xpluginlist.put(XType.xPermission, api);
	}
	
	public void registerXSignIn(XSignInApi api)
	{
		xpluginlist.put(XType.xSignIn, api);
	}
	
	public void registerXChat(XChatApi api)
	{
		xpluginlist.put(XType.xChat, api);
	}
	
	public void registerXBan(XBanApi api)
	{
		xpluginlist.put(XType.xBan, api);
	}
	
	public XPlugin getXPlugin(XType type)
	{
		return xpluginlist.get(type);
	}
	
	protected XManagerConnector getXManagerConnector()
	{
		return xmanager;
	}
}
