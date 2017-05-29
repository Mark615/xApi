package de.mark615.xapi.example;

import org.bukkit.plugin.java.JavaPlugin;

import de.mark615.xapi.XApi;
import de.mark615.xapi.interfaces.XPermissionApi;
import de.mark615.xapi.interfaces.XPlugin;
import de.mark615.xapi.versioncheck.VersionCheck.XType;

public class ExampleConnection
{
	public boolean setupXApi(JavaPlugin plugin)
	{
		XApi xapi = (XApi)plugin.getServer().getPluginManager().getPlugin("xApi");
    	if(xapi == null)
    		return false;
    	
    	XPlugin xplugin = null;
    	
    	//xpermission
    	XPermissionApi xperm = null;
    	xplugin = xapi.getXPlugin(XType.xPermission);
    	if (xplugin != null)
    		xperm = (XPermissionApi)xplugin;

    	//xsignin
    	XPermissionApi xsignin = null;
    	xplugin = xapi.getXPlugin(XType.xSignIn);
    	if (xplugin != null)
    		xsignin = (XPermissionApi)xplugin;
    	
    	return xplugin != null;
	}
}
