package de.mark615.xapi.versioncheck;

public class VersionNode
{
	private int minVersion;
	private int maxVersion;
	
	public VersionNode(int minVersion, int maxVersion)
	{
		this.minVersion = minVersion;
		this.maxVersion = maxVersion;
	}

	public int getMinVersion()
	{
		return minVersion;
	}

	public int getMaxVersion()
	{
		return maxVersion;
	}
}
