package de.mark615.xapi;

import java.util.HashMap;
import java.util.Map;

public class PriorityConfig extends PriorityConfigBase
{
	private SettingManager settings;
	
	public PriorityConfig(SettingManager settings)
	{
		super();
		this.settings = settings;
		for (String eventKey : settings.getConfig().getConfigurationSection("priority").getKeys(false))
		{
			prioritys.put(eventKey, new HashMap<String, Integer>());
		}
	}
	
	private void registerPlugin(String pluginName)
	{
		for (String eventKey : settings.getConfig().getConfigurationSection("priority").getKeys(false))
		{
			Map<String, Integer> map = prioritys.get(eventKey);
			if (map != null)
			{
				for (String pluginKey : settings.getConfig().getConfigurationSection("priority." + eventKey).getKeys(false))
				{
					if (pluginKey.equalsIgnoreCase(pluginName))
						map.put(pluginKey, settings.getConfig().getInt("priority." + eventKey + "." + pluginKey));
				}	
			}
		}
	}
	
	public void registerXPermission()
	{
		registerPlugin(PriorityConfigBase.XPERMISSION);
	}
}
