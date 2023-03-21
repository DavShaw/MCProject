package ssm.events;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import ssm.support.LogicFunctions;

public class SpecialItemRightClick implements Listener
{

	//Getting info from another classes
	LogicFunctions lfv = new LogicFunctions();
	
	@EventHandler
	public void Clicking(PlayerInteractEvent event)
	{
	
		//Checking if user has info in config path
		if(lfv.CheckConfigPathExist("playerinfo."+event.getPlayer().getUniqueId()))
		{
			//Checking if playerinfo.useruuid.status == true
			if(lfv.CheckSafeModeStatus("playerinfo."+event.getPlayer().getUniqueId()+".status"))
			{
				//Checking if user is making any type of right clicking (air or block)
				if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK)
				{
					//Checking if user is holding a blaze rod in its hand
					if(event.getPlayer().getInventory().getItemInHand().getType() == Material.BLAZE_ROD)
					{
						event.getPlayer().sendMessage("Se cumplió todo xd");
					}
				}
			}
		}
		
		return;
	}
	
	
}

