package ssm.commands;

import org.bukkit.command.CommandSender;


import org.bukkit.entity.Player;

import ssm.support.LogicFunctions;

public class Fly
{


    
    
    
    public void SSMFly(CommandSender sender)
    {
    	Player staff = (Player) sender;
    	
    	LogicFunctions lfv = new LogicFunctions();
    	
    	//Checking if staff is flying
    	if(staff.isFlying() == true)
    	{
    		staff.setAllowFlight(false);
    		staff.setFlying(false);
    		staff.sendMessage(lfv.Message("flyoff"));
    		
    	}
    	
    	//Checking if staff isnt flying
    	else if(staff.isFlying() == false)
    	{
    		staff.setAllowFlight(true);
    		staff.setFlying(true);
    		staff.sendMessage(lfv.Message("flyon"));
    	}
    	
    }
    

}
