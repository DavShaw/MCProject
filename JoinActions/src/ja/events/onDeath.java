package ja.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

import ja.commands.CMD_SPAWN;
import ja.support.SupportData;

public class onDeath implements Listener
{
	
	//Instance of class
	SupportData sdo = new SupportData();
	
	@EventHandler
	public void JoinEvent(PlayerRespawnEvent event)
	{
		if (sdo.ConfigPathGetter("config.spawn-on-death").equals("true"))
		{
			event.setRespawnLocation(sdo.GetSpawnData());
			CMD_SPAWN.command(event.getPlayer());
		}
		
	}

}