package de.mark615.xapi.interfaces;

import de.mark615.xchat.broadcast.BroadcastContainer;

public interface XChatApiInterface
{
	//broadcasts
	public boolean broadcast(String message);
	
	public boolean broadcast(String message, String permission);
	
	public boolean addBroadcast(BroadcastContainer container);
	
	public boolean disableBroadcast(String name);
	
	public boolean enableBroadcast(String name);
	
	public boolean reloadBroadcasts();
	
	//modt
}
