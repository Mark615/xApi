package de.mark615.xapi;

import java.util.HashMap;
import java.util.Map;

public class PriorityConfigBase
{
	public static final String XPERMISSION = "xpermission";

	public static final String PLAYERFIRSTJOIN = "playerfirstjoin";
	public static final String PLAYERRANKCHANGED = "playerrankchanged"; 
	
	protected Map<String, Map<String, Integer>> prioritys;
	
	public PriorityConfigBase()
	{
		this.prioritys = new HashMap<>();
	}
	
	public boolean canCallEvent(String type, String eventKey)
	{
		int callPlugin = 0;
		int highest = 0;
		
		if (prioritys.get(eventKey) == null)
			return false;
		
		for (String pluginKey : prioritys.get(eventKey).keySet())
		{
			int now = prioritys.get(eventKey).get(pluginKey);
					
			if (pluginKey.equalsIgnoreCase(type))
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
