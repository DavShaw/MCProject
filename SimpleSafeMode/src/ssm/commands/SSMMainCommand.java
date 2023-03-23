//SSMMainCommand controller - /ssm or /simplesafemode with arguments


package ssm.commands;

import ssm.simplesafemode.SimpleSafeMode;
import ssm.support.LogicFunctions;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SSMMainCommand implements CommandExecutor
{
	
	
	//Getting info from another classes
	LogicFunctions lfv = new LogicFunctions();
	
	// - /SSM test -> sendmsg
	
	//Constructor to allow to class SimpleSafeMode to register the command
	public SSMMainCommand(SimpleSafeMode simpleSafeMode){}

	
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		
		//Checking if CommandSender is a player
		if(sender instanceof Player)
		{
			//Checking if command has arguments
			if(args.length > 0)
			{
				//Checking if command has just 1 argument
				if(args.length > 0 && args.length < 2)
				{
					//Command with argument help
					if(args[0].equalsIgnoreCase("help"))
					{
						sender.sendMessage(String.format("%s\n%s", lfv.Message("prefix"),lfv.Message("help")));
					}
					
					//Command with argument reload
					else if(args[0].equalsIgnoreCase("reload"))
					{
						sender.sendMessage(String.format("%s%s", lfv.Message("prefix"),lfv.Message("reload")));
						lfv.ReloadConfig();
					}
					
					//Command with argument developers
					else if(args[0].equalsIgnoreCase("developers"))
					{
						sender.sendMessage(String.format("%s%s",lfv.Message("prefix"),lfv.Message("developers")));
						lfv.ReloadConfig();
					}
					
					//Command with argument test
					else if(args[0].equalsIgnoreCase("test"))
					{
						TestCMD testcmd = new TestCMD();
						
						testcmd.TempTest(sender);
						((Player) sender).getPlayer();
						

						
						
						
					}
					
					
					
					//Command with argument on
					else if(args[0].equalsIgnoreCase("on"))
						
					{
						Player player = (Player) sender;
						sender.sendMessage(String.format("%s%s",lfv.Message("prefix"),lfv.Message("ssm-on")));
						lfv.SimpleSafeModeEnabler(player, true);
					}
					
					//Command with argument of
					else if(args[0].equalsIgnoreCase("off"))
					{
						Player player = (Player) sender;
						sender.sendMessage(String.format("%s%s",lfv.Message("prefix"),lfv.Message("ssm-off")));
						lfv.SimpleSafeModeEnabler(player, false);
					}
					
					
					//Command with argument doesn't match with any previous conditions
					
					else
					{
						sender.sendMessage(lfv.Message("noexist"));
					}
					
				}
				
				//Checking if command has more than one argument
				else
				{
					sender.sendMessage(lfv.Message("noexist"));
				}
				
			}
			
			//Checking if commands hasn't arguments (Just main command)
			else
			{
				sender.sendMessage(lfv.Message("help"));
			}
			
		}
		
		//Checking if CommandSender isn't a player
		else if(!(sender instanceof Player))
		{
			Bukkit.getConsoleSender().sendMessage(lfv.Message("noplayer"));
			return false;
		}
		return false;
	}

	
	
}