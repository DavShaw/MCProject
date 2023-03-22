package ssm.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;


import org.bukkit.entity.Player;

public class TestCMD
{


    
    
    
    public void TempTest(CommandSender sender)
    {
    	Player player1 = (Player) sender;
    	
    	player1.sendMessage("Hola, tu objeto es: "+ player1.getPlayer());
    	
    }

}
