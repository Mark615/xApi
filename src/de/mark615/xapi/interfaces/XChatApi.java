package de.mark615.xapi.interfaces;

import java.util.UUID;

import de.mark615.xapi.XApi;
import de.mark615.xapi.events.BroadcastStateChangedEvent;

public abstract class XChatApi extends XPlugin implements XChatApiInterface
{
	public XChatApi(XApi plugin)
	{
		super(plugin);
	}
	
	
	//mute
	public boolean isPlayerMuted(UUID uuid)
	{
		//TODO
		return false;
	}
	
	public boolean isWorldMuted(String world)
	{
		//TODO
		return false;
	}
	
	public boolean isServerMuted(String server)
	{
		//TODO
		return false;
	}
	
	public boolean isChatroomMuted(String name)
	{
		//TODO
		return false;
	}
	
	
	//ban
	public boolean isPlayerBanned(UUID uuid)
	{
		//TODO
		return false;
	}
	
	
	//events
	public void createBroadcastSendEvent()
	{
		//TODO
	}
	
	public void createBroadcastAddedEvent()
	{
		//TODO
	}
	
	public void createBroadcastRemovedEvent()
	{
		//TODO
	}
	
	public void createBroadcastStateChangedEvent(boolean value)
	{
		BroadcastStateChangedEvent event = new BroadcastStateChangedEvent(value);
		this.plugin.getServer().getPluginManager().callEvent(event);
	}

}
