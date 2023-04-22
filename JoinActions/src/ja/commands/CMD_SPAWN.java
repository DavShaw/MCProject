package ja.commands;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import ja.support.SupportData;

public class CMD_SPAWN
{
	 private static SupportData sdo = new SupportData();
	 
	 public static boolean PlayerTeleported = false;
	 
	 public static void command(Player player)
	 {
		
		 try
		 {
			 player.teleport(sdo.GetSpawnData());
			 PlayerTeleported = true;
			 
			 if (sdo.ConfigPathGetter("config.send-spawn-message").equalsIgnoreCase("true"))
			 {
				 player.sendMessage(sdo.Message("spawn", null));
				 
			 }
		 }
		 
		 catch (Exception error)
		 {
			 Bukkit.getConsoleSender().sendMessage(sdo.Message("error-staff", null) + error);
			 player.sendMessage(sdo.Message("error-user", null));
		 }
		 
     }
}