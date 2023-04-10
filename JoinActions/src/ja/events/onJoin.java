package ja.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import ja.commands.CMD_SPAWN;
import ja.support.SupportData;

public class onJoin implements Listener
{
	
	//Instance of class
	SupportData sdo = new SupportData();
	
	@EventHandler
	public void SpawnJoinEvent(PlayerJoinEvent event)
	{
		if (sdo.ConfigPathGetter("config.spawn-on-join").equalsIgnoreCase("true"))
		{
			CMD_SPAWN.command(event.getPlayer());		
		}
		
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void TitleJoinEvent(PlayerJoinEvent event)
	{
		if (sdo.ConfigPathGetter("config.title-on-join").equals("true"))
		{
			event.getPlayer().sendTitle(sdo.Message("title",event.getPlayer()), sdo.Message("subtitle", event.getPlayer()));	
		}
	}
	
	
	

	@EventHandler
	public void MessageJoinEvent(PlayerJoinEvent event)
	{
		if (sdo.ConfigPathGetter("config.message-on-join").equals("true"))
		{
			event.getPlayer().sendMessage(sdo.Message("join-message", event.getPlayer()));
		}
	}
	
	
	
	

}
