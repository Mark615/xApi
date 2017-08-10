package de.mark615.xapi.versioncheck;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.mark615.xapi.XApi;

public class VersionCheck
{
	private static List<XType> xplugins;
	private static Map<XType, VersionRoot> versions;
	
	static
	{
		xplugins = new ArrayList<>();
		versions = new HashMap<>();

		xplugins.add(XType.xPermission);
		xplugins.add(XType.xSignIn);
		xplugins.add(XType.xChat);
		xplugins.add(XType.xBan);
		//xplugins.add(XType.xQuest);
		
		for (XType type : xplugins)
		{
			versions.put(type, new VersionRoot(type, getBuildNodes(type)));
		}
	}
	
	public static boolean isSupported(XType type, int curVersion)
	{
		VersionNode node = versions.get(type).getNodes().get(curVersion);
		if (node == null)
			node = versions.get(type).getHighestNode();
		return (node.getMinVersion() <= XApi.BUILD) && (XApi.BUILD <= node.getMaxVersion());
	}
	
	public static boolean isXPluginHigherXApi(XType type, int curBuild)
	{ 
		if (versions.get(type).getNodes().get(curBuild) == null)
			return true;
		return versions.get(type).getNodes().get(curBuild).getMaxVersion() > XApi.BUILD;
	}
	
	private static HashMap<Integer, VersionNode> getBuildNodes(XType type)
	{
		HashMap<Integer, VersionNode> nodes = new HashMap<>();
		if (type == XType.xPermission)
		{
			//xpermission version -> supports -> xapi versions
			nodes.put(1, new VersionNode(1, 1));
			nodes.put(2, new VersionNode(1, 2));
			nodes.put(3, new VersionNode(1, 3));
			nodes.put(4, new VersionNode(1, 3));
			nodes.put(5, new VersionNode(1, 6));
			nodes.put(6, new VersionNode(1, 6));
			nodes.put(8, new VersionNode(1, 6));
			return nodes;
		}
		
		if (type == XType.xSignIn)
		{
			nodes.put(1, new VersionNode(2, 2));
			nodes.put(2, new VersionNode(3, 3));
			nodes.put(3, new VersionNode(3, 5));
			nodes.put(4, new VersionNode(5, 5));
			nodes.put(5, new VersionNode(5, 5));
			nodes.put(6, new VersionNode(5, 6));
			return nodes;
		}
		
		if (type == XType.xChat)
		{
			nodes.put(1, new VersionNode(5, 6));
			return nodes;
		}
		
		if (type == XType.xBan)
		{
			return null;
		}
		
		/*
		if (type == XType.xQuest)
		{
			nodes.put(1, new VersionNode(4, 4));
			return nodes;
		}*/
		return null;
	}
	
	public enum XType
	{
		xPermission,
		xSignIn,
		xChat,
		xBan,
		xQuest
	}
}
