package ja.events;

import ja.commands.CMD_SPAWN;
import ja.support.SupportData;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class onMove implements Listener
{

	SupportData sdo = new SupportData();
	
	@EventHandler
	public void AntiVoidTouch(PlayerMoveEvent event)
	{
		if(sdo.ConfigPathGetter("config.spawn-on-touch-void").equals("true"))
		{
			
			float y = (float) event.getPlayer().getLocation().getY();
			try
			{
				float AntiTouchNumber = Float.parseFloat(sdo.ConfigPathGetter("data.anti-void-touch"));
				
				if (y <= AntiTouchNumber)
				{
					CMD_SPAWN.command(event.getPlayer());
				}
			}
			
			catch(Exception error)
			{
				Bukkit.getConsoleSender().sendMessage(sdo.Message("error-staff", null));
			}
			
		}
			
		
	}
	
}
