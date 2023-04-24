package ja.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

import ja.commands.CMD_SPAWN;

public class onFall implements Listener
{

	//SUPPORT METHOD FOR Class "onMove"
	@EventHandler
	public void AntiFallDamage(EntityDamageEvent event)
	{
		if(event.getEntity() instanceof Player && event.getCause() == DamageCause.FALL )
		{
			if(CMD_SPAWN.PlayerTeleported)
			{
				CMD_SPAWN.PlayerTeleported = false;
				event.setCancelled(true);
			}
			
		}
	}
	
	
}
