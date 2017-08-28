package de.mark615.xapi;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.UUID;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import de.mark615.xapi.object.XUtil;

public class SettingManager
{
	static SettingManager instance = new SettingManager();
	
	public static SettingManager getInstance()
	{
		return instance;
	}
	
    private FileConfiguration config;
    private File cFile;
    
    private int dataID;
   
    public void setup(Plugin p)
    {
    	if (!p.getDataFolder().exists())
    		p.getDataFolder().mkdir();
    	
    	//load config
    	cFile = new File(p.getDataFolder(), "config.yml");
    	if(!cFile.exists())
    		p.saveResource("config.yml", true);
		config = YamlConfiguration.loadConfiguration(cFile);
		config.options().copyDefaults(true);
		
		//Load default config
		try
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getResource("config.yml"), "UTF-8"));
			YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(br);
			config.setDefaults(defConfig);	
		}
		catch(Exception e)
		{
			XUtil.severe("cant copy default config.yml", e);
		}
    }
    
    public FileConfiguration getConfig()
    {
        return config;
    }
   
    public void reloadConfig()
    {
    	config = YamlConfiguration.loadConfiguration(cFile);
    }
   
    public void saveConfig()
    {
        try {
            config.save(cFile);
        }
        catch (IOException e) {
        	XUtil.severe("Could not save config.yml!");
        }
    }
    
    
    
    public boolean hasCheckVersion()
    {
    	return config.getBoolean("updatecheck", true);
    }
    
    public void setAPIKey(UUID uuid)
    {
    	config.set("apikey", uuid.toString());
    }
    
    public UUID getAPIKey()
    {
    	return config.getString("apikey", null) == null ? null : UUID.fromString(config.getString("apikey"));
    }
    
    public void setDataID(int dataID)
    {
    	this.dataID = dataID;
    }
    
    public int getDataID()
    {
    	return dataID;
    }
    
    public ConfigurationSection getXManagerSection()
    {
    	return config.getConfigurationSection("xmanager");
    }
    
    public void setXManagerValue(String path, Object value)
    {
    	config.set("xmanager." + path, value);
    }
}
