package ssm.support;

import org.bukkit.Bukkit;

//import ssm.simplesafemode.SimpleSafeMode;

//import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;

import ssm.simplesafemode.SimpleSafeMode;

public class LogicFunctions
{
	
	//Colors
	public ChatColor white = ChatColor.WHITE;
	public ChatColor black = ChatColor.BLACK;
	public ChatColor red = ChatColor.RED;
	public ChatColor blue = ChatColor.BLUE;
	public ChatColor yellow = ChatColor.YELLOW;
    public ChatColor green = ChatColor.GREEN;
    
    //Object from another classes
    SimpleSafeMode ssmv = (SimpleSafeMode) Bukkit.getPluginManager().getPlugin("SimpleSafeMode");
    
    
    
   //Method to reload SimpleSafeMode config
    public void ReloadConfig()
    {
    	ssmv.reloadConfig();
    }
    
  //Method to get information in config.yml (Give it an argument and i'll returns a string)
    public String Message(String arg)
    {
    	//object to get config.yml information
    	FileConfiguration config = ssmv.getConfig();
    
    	
    	
    	//If arg == "prefix"
    	if(arg.equals("prefix"))
    	{
    		String path = "message."+arg;
    		String msg = config.getString(path);
    		return ChatColor.translateAlternateColorCodes('&', msg);
    		
    	}
    	
    	//If arg == "reload"
    	if(arg.equals("reload"))
    	{
    		String path = "message."+arg;
    		String msg = config.getString(path);
    		return ChatColor.translateAlternateColorCodes('&', msg).replaceAll("%prefix%", Message("prefix"));
    	}
    	
    	//If arg == nopermissions
    	if(arg.equals("nopermissions"))
    	{
    		String path = "message."+arg;
    		String msg = config.getString(path);
    		return ChatColor.translateAlternateColorCodes('&', msg);
    	}
    	
    	//If arg == noplayer
    	if(arg.equals("noplayer"))
    	{
    		String path = "message."+arg;
    		String msg = config.getString(path);
    		return ChatColor.translateAlternateColorCodes('&', msg);
    	}
    	
    	//If arg == noexist
    	if(arg.equals("noexist"))
    	{
    		String path = "message."+arg;
    		String msg = config.getString(path);
    		return ChatColor.translateAlternateColorCodes('&', msg);
    	}
    	
    	//If arg == developers
    	if(arg.equals("developers"))
    	{
    		return ssmv.developers.toString();
    	}
    	
    	//If arg == help
    	if(arg.equals("help"))
    	{
    		String msg = "";
    		msg += ChatColor.translateAlternateColorCodes('&', config.getString("message.help-header"));
    		msg += "\n";
    		msg += ChatColor.translateAlternateColorCodes('&', config.getString("message.help-help"));
    		msg += "\n";
    		msg += ChatColor.translateAlternateColorCodes('&', config.getString("message.help-reload"));
    		msg += "\n";
    		msg += ChatColor.translateAlternateColorCodes('&', config.getString("message.help-developers"));
    		msg += "\n";
    		msg += ChatColor.translateAlternateColorCodes('&', config.getString("message.help-footer"));
    		return msg;
    	}
    	
    	
    	
    	//If arg != previous conditions
    	else
    	{
    		return null;
    	}
    	
    }
}
