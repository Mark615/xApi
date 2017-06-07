package de.mark615.xapi;

import java.util.HashMap;
import java.util.Map;

public class PriorityConfigBase
{
	public static final String XPERMISSION = "xpermission";
	public static final String XSIGNIN = "xsignin";
	public static final String XCHAT = "xchat";
	public static final String XBAN = "xban";

	public static final String PLAYERFIRSTJOIN = "playerfirstjoin";
	public static final String PLAYERRANKCHANGED = "playerrankchanged";
	public static final String PLAYERAUTORANKINGCHANGED = "playerautorankingchanged";
	public static final String PLAYERPASSWORDCHANGED = "playerpasswordchanged";
	public static final String PLAYERPASSWORDRESET = "playerpasswordreset";
	public static final String PLAYERLOGGEDIN = "playerloggedin";
	public static final String MAINTENANCESWITCH = "maintenanceswitch";
	
	protected Map<String, Map<String, Integer>> prioritys;
	
	public PriorityConfigBase()
	{
		this.prioritys = new HashMap<>();
	}
	
	public boolean canCallEvent(String plugin, String type)
	{
		int callPlugin = 0;
		int highest = 0;
		
		if (prioritys.get(type) == null)
			return false;
		
		for (String pluginKey : prioritys.get(type).keySet())
		{
			int now = prioritys.get(type).get(pluginKey);
					
			if (pluginKey.equalsIgnoreCase(plugin))
			{
				callPlugin = now;
			}
			else
			if (now > highest)
			{
				highest = now;
			}
		}
		
		return callPlugin >= highest;
	}
}
