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
	     sdo.ConfigSetPathInfo("data.world",world);
	     sdo.ConfigSetPathInfo("data.x",x);
	     sdo.ConfigSetPathInfo("data.y",y);
	     sdo.ConfigSetPathInfo("data.z",z);
	     sdo.ConfigSetPathInfo("data.yaw",yaw);
	     sdo.ConfigSetPathInfo("data.pitch",pitch);
	     
	     player.sendMessage(sdo.Message("spawn-set", null));
    }
}

