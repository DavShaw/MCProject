package ja.events;

import ja.commands.CMD_SPAWN;
import ja.support.SupportData;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class onMove implements Listener
{
	
	
	
	SupportData sdo = new SupportData();
	public void AntiVoidTouch(PlayerMoveEvent event)
	{
		float y = (float) event.getPlayer().getLocation().getY();
		
		event.getPlayer().sendMessage("Se detectó el evento de movimiento... Capa: " + y);
		
		if (y <= 10)
		{
			CMD_SPAWN.command(event.getPlayer());
		}

		
	}
	
}
