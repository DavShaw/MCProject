package ssm.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import ssm.support.LogicFunctions;

public class ToServerQuit implements Listener
{

	//Getting info from another classes
	LogicFunctions lfv = new LogicFunctions();
	
	@EventHandler
	public void EventsToJoin(PlayerQuitEvent event)
	{
		
		//Checking if config.auto-status-off-on-quit == true
		if(lfv.ConfigPathValueGetter("config.auto-status-off-on-quit").equals("true"))
		{
			//Checking if player has info
			if(lfv.CheckConfigPathExist("playerinfo."+event.getPlayer().getUniqueId()))
			{
				//Changing status info to false
				lfv.ChangePathInfo("playerinfo."+event.getPlayer().getUniqueId()+".status", "false");
				lfv.ChangePathInfo("playerinfo."+event.getPlayer().getUniqueId()+".ownchat", "true");
			}
		}
			
		
	}
	
}
