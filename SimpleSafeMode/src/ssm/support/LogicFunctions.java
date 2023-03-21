package ssm.support;

import org.bukkit.Bukkit;

import ssm.simplesafemode.SimpleSafeMode;

//import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;



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
    
    //Method to set ssm-on and ssm-off config
    public void SimpleSafeModeEnabler(Player player, boolean Mode)
    {
    	FileConfiguration config = ssmv.getConfig();
    	
    	//If player send true (on)
    	if(Mode == true)
    	{
    		//playerinfo:
    		//    89394483-8629-4f79-aa9e-e010c7e9ce43:
    		//        name: KingXRP
    		//        mode: true
    		config.set("playerinfo."+player.getUniqueId()+".name", String.format("%s", player.getName()));
    		config.set("playerinfo."+player.getUniqueId()+".status", String.format("%s", Mode));
    		ssmv.saveConfig();
    	}
    	
    	//If player send false (off)
    	else if(Mode == false)
    	{
    		//playerinfo:
    		//    89394483-8629-4f79-aa9e-e010c7e9ce43:
    		//        name: KingXRP
    		//        mode: false
    		config.set("playerinfo."+player.getUniqueId()+".name", String.format("%s", player.getName()));
    		config.set("playerinfo."+player.getUniqueId()+".status", String.format("%s", Mode));
    		ssmv.saveConfig();
    	}
    }
    
    
    //Method to check if any path exist
    public boolean CheckConfigPathExist(String path)
    {
    	FileConfiguration config = ssmv.getConfig();
    	
    	try
    	{
    		if(config.getString(path) != null)
    		{
    			return true;
    		}
    	}
    	catch (NullPointerException error)
    	{
    		return false;
    	}
  
    	
    	return false;
    }
    
    
    //Method to check if SafeMode status is on or off (for on returns true, for off returns false)
    public boolean CheckSafeModeStatus(String path)
    {
    	FileConfiguration config = ssmv.getConfig();
    	if(config.getString(path).equals("true"))
    	{
    		return true;
    	}
    	return false;
    }
    
    
    //Method to read true or false from playerinfo.uuid.mode: true or false
    public void SimpleSafeModeStatusReader()
    {
    	
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
    	
    	//If arg == on
    	if(arg.equals("ssm-on"))
    	{
    		String path = "message."+arg;
    		String msg = config.getString(path);
    		return ChatColor.translateAlternateColorCodes('&', msg);
    	}
    	
    	//If arg == off
    	if(arg.equals("ssm-off"))
    	{
    		String path = "message."+arg;
    		String msg = config.getString(path);
    		return ChatColor.translateAlternateColorCodes('&', msg);
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
    		msg += ChatColor.translateAlternateColorCodes('&', config.getString("message.help-ssm-on"));
    		msg += "\n";
    		msg += ChatColor.translateAlternateColorCodes('&', config.getString("message.help-ssm-off"));
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