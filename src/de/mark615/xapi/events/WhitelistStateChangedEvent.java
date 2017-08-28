package de.mark615.xapi.events;

public class WhitelistStateChangedEvent extends StateChangedEvent
{
	public WhitelistStateChangedEvent(boolean value)
	{
		super(value);
	}
	
	public boolean isWhitelistEnabled()
	{
		return value;
	}
}
