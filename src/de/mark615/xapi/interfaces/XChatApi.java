package de.mark615.xapi.interfaces;

import java.util.UUID;

import de.mark615.xapi.XApi;

public abstract class XChatApi extends XPlugin implements XChatApiInterface
{
	public XChatApi(XApi plugin)
	{
		super(plugin);
	}
	
	
	//mute
	public boolean isPlayerMuted(UUID uuid)
	{
		return false;
	}
	
	public boolean isWorldMuted(String world)
	{
		return false;
	}
	
	public boolean isServerMuted(String server)
	{
		return false;
	}
	
	public boolean isChatroomMuted(String name)
	{
		return false;
	}
	
	
	//ban
	public boolean isPlayerBanned(UUID uuid)
	{
		return false;
	}

}
