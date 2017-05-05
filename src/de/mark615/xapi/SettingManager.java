package de.mark615.xapi;

import java.io.File;
import java.io.InputStream;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class SettingManager
{    
    FileConfiguration config;
    File cFile;
   
    public SettingManager(Plugin p)
    {
    	if (!p.getDataFolder().exists())
    	{
    		p.getDataFolder().mkdir();
    	}
    	
    	cFile = new File(p.getDataFolder(), "config.yml");
    	if(!cFile.exists())
    	{
    		p.saveResource("config.yml", true);
    	}
    	
    	//Store it
    	config = YamlConfiguration.loadConfiguration(cFile);
    	config.options().copyDefaults(true);
    	
    	//Load default messages
    	InputStream defMessageStream = p.getResource("config.yml");
    	YamlConfiguration defMessages = YamlConfiguration.loadConfiguration(defMessageStream);
		config.setDefaults(defMessages);
    }
    
    
   
    public FileConfiguration getConfig()
    {
        return config;
    }
   
    public void reloadConfig()
    {
    	config = YamlConfiguration.loadConfiguration(cFile);
    }
}
