package ja.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

import ja.support.SupportData;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MainCommand implements CommandExecutor
{

	
	//Instance of class
	SupportData sdo = new SupportData();
	
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		
		if (sender instanceof Player)
		{
			Player player = (Player) sender;
			if (args.length == 1)
			{		
				if (args[0].equalsIgnoreCase("help"))
				{
					
					if (player.hasPermission("ja.help") || player.isOp())
					{
						player.sendMessage(sdo.Message("help", null));
					}
					else
					{
						player.sendMessage(sdo.Message("no-permission", null));
					}
					
				}
				
				
				else if (args[0].equalsIgnoreCase("setspawn"))
				{
					
					if (player.hasPermission("ja.setspawn") || player.isOp())
					{
						CMD_SETSPAWN.command(player);
					}
					
					else
					{
						player.sendMessage(sdo.Message("no-permission", null));
					}
					
				}
				
				else if (args[0].equalsIgnoreCase("spawn"))
				{
					
					if (player.hasPermission("ja.spawn") || player.isOp())
					{
						CMD_SPAWN.command(player);
					}
					
					else
					{
						player.sendMessage(sdo.Message("no-permission", null));
					}
					
					
				}
				
				else if (args[0].equalsIgnoreCase("reload"))
				{
					
					if (player.hasPermission("ja.reload") || player.isOp())
					{
						CMD_RELOAD.command();
						player.sendMessage(sdo.Message("reload",null));
					}
					
					else
					{
						player.sendMessage(sdo.Message("no-permission",null));
					}
					
					
				}
				
				else if (args[0].equalsIgnoreCase("version"))
				{
					if (player.hasPermission("ja.version") || player.isOp())
					{
						player.sendMessage(sdo.Message("version",null));
					}
					
					else
					{
						player.sendMessage(sdo.Message("no-permission",null));
					}
					
					
				}
				
				else if (args[0].equalsIgnoreCase("developer"))
				{
					if (player.hasPermission("ja.developer") || player.isOp())
					{
						player.sendMessage(sdo.Message("developer",null));
					}
					
					else
					{
						player.sendMessage(sdo.Message("no-permission",null));
					}
					
					
				}
				
				else if (args[0].equalsIgnoreCase("url"))
				{
					if (player.hasPermission("ja.url") || player.isOp())
					{
						player.sendMessage(sdo.Message("url",null));
					}
					
					else
					{
						player.sendMessage(sdo.Message("no-permission",null));
					}
				}
				
				else if (args[0].equalsIgnoreCase("item"))
				{
					if (player.hasPermission("ja.item") || player.isOp())
					{
						player.sendMessage("Item obtenido");
						CMD_GET_ITEM.GetItems(player);
					}
					
					else
					{
						player.sendMessage(sdo.Message("no-permission",null));
					}
				}
				
				else
				{
					player.sendMessage(sdo.Message("no-exist",null));
				}
			
				
				
			}
			
			else
			{
				player.sendMessage(sdo.Message("no-exist",null));
			}
			
		}
		
		else
		{
			Bukkit.getConsoleSender().sendMessage(sdo.Message("no-player",null));
		}
		
		return false;
	}

}