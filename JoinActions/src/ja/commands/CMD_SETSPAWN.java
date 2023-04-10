package ja.commands;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import ja.support.SupportData;

public class CMD_SETSPAWN
{
	
	 private static SupportData sdo = new SupportData();
	 public static void command(Player player)
	 {
		 Location location = player.getLocation();
		 
	     //Getting location information
		 String world = location.getWorld().getName();
	     String x = String.valueOf((float) location.getX());
	     String y = String.valueOf((float) location.getY());
	     String z = String.valueOf((float) location.getZ());
	     String yaw = String.valueOf((float) location.getYaw());
	     String pitch = String.valueOf((float) location.getPitch());
	     
	     //Save in config.yml
	     sdo.SetPathInfo("data.world",world);
	     sdo.SetPathInfo("data.x",x);
	     sdo.SetPathInfo("data.y",y);
	     sdo.SetPathInfo("data.z",z);
	     sdo.SetPathInfo("data.yaw",yaw);
	     sdo.SetPathInfo("data.pitch",pitch);
	     
	     player.sendMessage(sdo.Message("spawn-set", null));
    }
}

