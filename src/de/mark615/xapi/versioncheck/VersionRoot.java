package de.mark615.xapi.versioncheck;

import java.util.HashMap;

import de.mark615.xapi.versioncheck.VersionCheck.XType;

public class VersionRoot
{
	private XType type;
	private HashMap<Integer, VersionNode> nodes;
	
	public VersionRoot(XType type, HashMap<Integer, VersionNode> nodes)
	{
		this.nodes = nodes;
		this.type = type;
	}
	
	public XType getType()
	{
		return this.type;
	}

	public HashMap<Integer, VersionNode> getNodes()
	{
		return this.nodes;
	}
}
