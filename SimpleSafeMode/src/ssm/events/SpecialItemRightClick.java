package ssm.events;

import java.util.List;

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
						List<Player> OnlinePlayers = lfv.GetOnlinePlayer();
						//OnlinePlayers.remove(event.getPlayer());
						int TempPlayer = lfv.RandomNumber(OnlinePlayers);
						Player p2 = OnlinePlayers.get(TempPlayer);
						event.getPlayer().sendMessage("Se cumplió todo xd");
						event.getPlayer().sendMessage("Users On: " + OnlinePlayers);
		
						event.getPlayer().sendMessage("El random number en función del len(list) es: "+ TempPlayer);
						event.getPlayer().sendMessage("El user con index " + TempPlayer + " es: " + p2);
						
						//Taking p2 position
						World CurrentWorld = p2.getWorld();
						Location p2location;
						p2location = p2.getLocation();
						double x,y,z;
						x = p2location.getX();
						y = p2location.getY();
						z = p2location.getZ();
						
						
						event.getPlayer().teleport(p2location);
						
						
						
						
					}
				}
				
				
				
			}
		}
		
		return;
	}
	
	
}

