package ssm.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ssm.support.LogicFunctions;

public class OwnChat
{

	public void SSMOwnChat(CommandSender sender)
    {
    	Player staff = (Player) sender;
    	LogicFunctions lfv = new LogicFunctions();
    	
    	//Checking if staff has ownchatoff: true
    	if(lfv.ConfigPathValueGetter("playerinfo."+staff.getUniqueId()+".ownchat").equals("true"))
    	{
    		//Player has chat enabled, lets disabled it
    		lfv.ChangePathInfo("playerinfo."+staff.getUniqueId()+".ownchat", "false");
    		staff.sendMessage(lfv.Message("ownchatoff"));
    	}
    	
    	//Checking if staff has ownchatoff: false
    	else if(lfv.ConfigPathValueGetter("playerinfo."+staff.getUniqueId()+".ownchat").equals("false"))
        {
    		//Player has chat disabled, lets enabled it
    		lfv.ChangePathInfo("playerinfo."+staff.getUniqueId()+".ownchat", "true");
    		staff.sendMessage(lfv.Message("ownchaton"));
        }
    	
    	
    }
	
	
}
