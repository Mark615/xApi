package de.mark615.xapi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.bukkit.Bukkit;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

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
		try
		{
			sendGet("setmode?type=xApi&mode=on&build=" + XApi.BUILD);
		}
		catch(Exception e)
		{
			severe("Can't generate onEnable webrequest");
		}
		
		checkUpdate();
	}
	
	public static void onDisable()
	{
		try
		{
			sendGet("setmode?type=xApi&mode=off&build=" + XApi.BUILD);
		}
		catch(Exception e)
		{
			severe("Can't generate onDisable webrequest");
		}
	}
	
	private static void checkUpdate()
	{
		try
		{
		    JsonElement jsonelement = new JsonParser().parse(sendGet("checkversion?type=xApi&build=" + XApi.BUILD));
		    JsonObject json = jsonelement.getAsJsonObject();
			if (json.has("build") && json.get("build").getAsInt() > XApi.BUILD)
			{
				info("A newer version of xApi is avaible. V." + json.get("version").getAsString());
			}
		}
		catch(Exception e)
		{
			severe("Can't generate checkUpdate webrequest");
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
