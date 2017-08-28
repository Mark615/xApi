package de.mark615.xapi.events;

public class BroadcastStateChangedEvent extends StateChangedEvent
{
	public BroadcastStateChangedEvent(boolean value)
	{
		super(value);
	}
	
	public boolean isBroadcastEnabled()
	{
		return value;
	}
}
