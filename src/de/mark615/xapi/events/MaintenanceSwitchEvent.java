package de.mark615.xapi.events;

public class MaintenanceSwitchEvent extends StateChangedEvent
{
	public MaintenanceSwitchEvent(boolean value)
	{
		super(value);
	}
	
	public boolean getNewMaintenanceMode()
	{
		return this.value;
	}
}
