package ssm.events;

import ssm.support.LogicFunctions;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class OwnChatStop implements Listener
{
	
	
	
	@EventHandler
	public void onPlayerWrite(AsyncPlayerChatEvent event)
	{
		LogicFunctions lfv = new LogicFunctions();
		Player staff = event.getPlayer();
		String path = "playerinfo." + staff.getUniqueId();
		
		//Checking if staff has config
		if(lfv.CheckConfigPathExist(path))
		{
			//Checking if staff has ownchat as false (Do not talk)
			if(lfv.ConfigPathValueGetter(path+".ownchat").equals("false"))
			{
				event.setCancelled(true);
			}
		}	
	}
}
