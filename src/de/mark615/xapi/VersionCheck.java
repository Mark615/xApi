package de.mark615.xapi;

public class VersionCheck
{
	private final static int SUPPORTED_XPERMISSION_MIN = 1;
	private final static int SUPPORTED_XPERMISSION_MAX = 2;
	
	public static boolean isSupported(XType type, int curVersion)
	{
		switch(type)
		{
		case xPermission:
			return (SUPPORTED_XPERMISSION_MIN <= curVersion) && (curVersion <= SUPPORTED_XPERMISSION_MAX);
		case xLogin:
		case xChat:
		case xBan:
		case xQuest:
			return false;
		}
		
		return false;
	}
	
	public static int getXPermissionMax()
	{ 
		return SUPPORTED_XPERMISSION_MAX;
	}
	
	public enum XType
	{
		xPermission,
		xLogin,
		xChat,
		xBan,
		xQuest
	}
}
