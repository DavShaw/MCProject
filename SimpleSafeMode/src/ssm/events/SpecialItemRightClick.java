package ssm.events;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
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
	public void SpecialItemRightClicking(PlayerInteractEvent event)
	{
		Player staff = event.getPlayer();
		
	
		//Checking if user has info in config path
		if(lfv.CheckConfigPathExist("playerinfo."+staff.getUniqueId()))
		{
			//Checking if playerinfo.useruuid.status == true
			if(lfv.CheckSafeModeStatus("playerinfo."+staff.getUniqueId()+".status"))
			{
				//Checking if user is making any type of right clicking (air or block)
				if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK)
				{
					//Checking if user is holding a blaze rod in its hand
					if(staff.getInventory().getItemInHand().getType() == Material.BLAZE_ROD)
					{
						//Getting Online players list
						List<Player> OnlinePlayers = lfv.GetOnlinePlayer();
	
						
						//Checking if Online players list is > than 1 (that means that staff isn't alone on server)
						if(OnlinePlayers.size() > 1)
						{
										
							
							//Taking off staff with permission
							
							for(int i = 0;i < OnlinePlayers.size(); i++)
							{
								Player CurrentPlayer = OnlinePlayers.get(i);
								if(CurrentPlayer.hasPermission("ssm.status.on"))
								{
									OnlinePlayers.remove(CurrentPlayer);
								}
							}
							//OnlinePlayers.remove(staff);
							
							//Getting a random number (Valid for current list size)
							int RandomNumber = lfv.RandomNumber(OnlinePlayers);
							
							Player user = OnlinePlayers.get(RandomNumber);
							Location user_location = user.getLocation();
							
							staff.setAllowFlight(true);
							staff.setFlying(true);
							staff.teleport(user_location);
							staff.sendMessage("Has sido teleportado al jugador " + user.getDisplayName());
						}
						
						else if(OnlinePlayers.size() <= 1)
						{
							staff.sendMessage("Oh, no, parece que no hay suficiente jugadores :(");
						}
						
						
						
						

					}
				}
				
				
				
			}
		}
		
		return;
	}
	
	
}

