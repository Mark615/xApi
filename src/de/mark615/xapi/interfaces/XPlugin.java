package de.mark615.xapi.interfaces;

import de.mark615.xapi.PriorityConfigBase;
import de.mark615.xapi.XApi;

public class XPlugin
{
	protected XApi plugin;
	protected PriorityConfigBase priorityBase;
	
	public XPlugin(XApi plugin)
	{
		this.plugin = plugin;
		this.priorityBase = plugin.getPriorityConfig();
	}
}
