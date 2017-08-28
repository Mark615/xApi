package de.mark615.xapi.events;

public class BlacklistStateChangedEvent extends StateChangedEvent
{
	public BlacklistStateChangedEvent(boolean value)
	{
		super(value);
	}
	
	public boolean isBlacklistEnabled()
	{
		return value;
	}
}
