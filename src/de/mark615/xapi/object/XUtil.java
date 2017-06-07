package de.mark615.xapi.object;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.UUID;

import org.bukkit.Bukkit;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import de.mark615.xapi.SettingManager;
import de.mark615.xapi.XApi;

public class XUtil
{
	public static void info(String info)
	{
		Bukkit.getLogger().info(XApi.PLUGIN_NAME + info);
	}

	public static void warning(String severe)
	{
		Bukkit.getLogger().info(XApi.PLUGIN_NAME + "[WARNING] " + severe);
	}
	
	public static void severe(String severe)
	{
		Bukkit.getLogger().severe(XApi.PLUGIN_NAME + severe);
	}
	
	public static void debug(Exception e)
	{
		e.printStackTrace();
	}


	
	
	public static void onEnable()
	{
		if (onStart())
		{
			try
			{
				String value = sendGet("setmode?uuid=" + SettingManager.getInstance().getAPIKey().toString() + "&type=xApi&mode=on&build=" + XApi.BUILD);
				JsonElement parser = new JsonParser().parse(value);
				JsonObject json = parser.getAsJsonObject();
				if (json.has("dataid"))
				{
					SettingManager.getInstance().setDataID(json.get("dataid").getAsInt());
				}
			}
			catch(Exception e)
			{
				severe("Can't generate onEnable webrequest");
				debug(e);
			}
		}
	}
	
	private static boolean onStart()
	{
		try
		{
			String url = "startup?servername=" + Bukkit.getServerName() + "";
			if (SettingManager.getInstance().getAPIKey() != null)
			{
				url = url + "&uuid=" + SettingManager.getInstance().getAPIKey().toString();
			}
			String value = sendGet(url);
			if (value != null && value.length() != 0)
			{
				JsonElement parser = new JsonParser().parse(value);
				JsonObject json = parser.getAsJsonObject();
				if (json.has("error"))
				{
					severe("JSON error: " + json.get("error").getAsString());
					if (json.has("action") && json.get("action").getAsString().equalsIgnoreCase("dropUUID"))
					{
						if (UUID.fromString(json.get("uuid").getAsString()).equals(SettingManager.getInstance().getAPIKey()))
						{
							SettingManager.getInstance().setAPIKey(null);
							return onStart();
						}
					}
				}
				else
				if (json.has("uuid"))
				{
					SettingManager.getInstance().setAPIKey(UUID.fromString(json.get("uuid").getAsString()));
					SettingManager.getInstance().saveConfig();
				}
				return true;
			}
			return false;
		}
		catch(Exception e)
		{
			severe("Can't generate onStart webrequest");
			debug(e);
			return false;
		}
	}
	
	public static void onDisable()
	{
		try
		{
			sendGet("setmode?uuid=" + SettingManager.getInstance().getAPIKey().toString() + "&dataid=" + SettingManager.getInstance().getDataID() + "&" + 
					"type=xApi&mode=off&build=" + XApi.BUILD);
		}
		catch(Exception e)
		{
			severe("Can't generate onDisable webrequest");
			debug(e);
		}
	}
	
	// HTTP GET request
	private static String sendGet(String message) throws Exception {

		String url = "http://134.255.217.210:8080/";

		URL obj = new URL(url + message);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		//add request header
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		
		//reponse
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		return response.toString();
	}
}
