package ja.support;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import ja.joinactions.JoinActions;

public class SupportData
{

	//Object from another classes
	JoinActions jao = JoinActions.getInstance();

	
	public void ReloadConfig()
	{
		jao.reloadConfig();
	}
	
	public void ReloadItems()
	{
		jao.reloadItems();
	}
	
	public boolean ConfigPathExist(String path)
    {
    	FileConfiguration config = jao.getConfig();
    	
    	try
    	{
    		if(config.getString(path) != null) {return true;}
    	}
    	
    	catch (NullPointerException error) {return false;}
    	return false;
    }

	public String ConfigPathGetter(String path)
    {
		if (ConfigPathExist(path))
		{
			FileConfiguration config = jao.getConfig();
	    	return config.getString(path);
		}
		return null;
		
    	
    }

	public void ConfigSetPathInfo(String path, String pathinfo)
    {
    	FileConfiguration config = jao.getConfig();
    	config.set(path,pathinfo);
    	jao.saveConfig();
    }

	public boolean ItemsPathExist(String path)
    {
    	FileConfiguration config = jao.getItems();
    	
    	try
    	{
    		if(config.getString(path) != null) {return true;}
    	}
    	
    	catch (NullPointerException error) {return false;}
    	return false;
    }

	public String ItemsPathGetter(String path)
    {
		if (ItemsPathExist(path))
		{
			FileConfiguration config = jao.getItems();
	    	return config.getString(path);
		}
		return null;
		
    	
    }

	public void ItemsSetPathInfo(String path, String pathinfo)
    {
    	FileConfiguration config = jao.getItems();
    	config.set(path,pathinfo);
    	jao.SaveItems();
    }
	
	public Location GetSpawnData()
	{
		try
		 {
			//Getting info from config.yml
			 World world = Bukkit.getWorld(ConfigPathGetter("data.world"));
			 float x = Float.parseFloat(ConfigPathGetter("data.x"));
			 float y = Float.parseFloat(ConfigPathGetter("data.y"));
			 float z = Float.parseFloat(ConfigPathGetter("data.z"));
			 float yaw = Float.parseFloat(ConfigPathGetter("data.yaw"));
			 float pitch = Float.parseFloat(ConfigPathGetter("data.pitch"));

			 //Returning location
			 return (new Location(world,x,y,z,yaw,pitch));
		 }
		 
		 catch (Exception error)
		 {
			 Bukkit.getConsoleSender().sendMessage(Message("error-staff", null) + error);
			 return null;
		 }
		
		
	}
	
    public String EnchantNameGetter(String enchant_format)
    {

        try
        {
            return enchant_format.substring(0, enchant_format.indexOf(":"));
        }
        catch (Exception error)
        {
            return "";
        }

    }

    public String EnchantLevelGetter(String enchant_format)
    {

        try
        {
            return enchant_format.substring(enchant_format.indexOf(":") + 1, enchant_format.length());
        }
        catch (Exception error)
        {
            return "";
        }

    }

	public String Message(String arg, Player player)
    {
    	//object to get config.yml information
    	FileConfiguration config = jao.getConfig();
    	
    	if(arg.equals("prefix"))
    	{
    		String msg = config.getString("config."+arg);
    		return ChatColor.translateAlternateColorCodes('&', msg);
    	}
    
    	if(arg.equals("reload"))
    	{
    		String msg = config.getString("messages."+arg);
    		return ChatColor.translateAlternateColorCodes('&', msg).replaceAll("%prefix%",Message("prefix",null));
    	}
    	
    	
    	if(arg.equals("spawn"))
    	{
    		String msg = config.getString("messages."+arg);
    		return ChatColor.translateAlternateColorCodes('&', msg).replaceAll("%prefix%",Message("prefix", null));
    	}
    	
    	
    	if(arg.equals("spawn-set"))
    	{
    		String msg = config.getString("messages."+arg);
    		return ChatColor.translateAlternateColorCodes('&', msg).replaceAll("%prefix%",Message("prefix", null));
    	}
    	
    	
    	if(arg.equals("no-player"))
    	{
    		String msg = config.getString("messages."+arg);
    		return ChatColor.translateAlternateColorCodes('&', msg).replaceAll("%prefix%",Message("prefix", null));
    	}
    	
    	if(arg.equals("no-permission"))
    	{
    		String msg = config.getString("messages."+arg);
    		return ChatColor.translateAlternateColorCodes('&', msg).replaceAll("%prefix%",Message("prefix", null));
    	}
    	
    	if(arg.equals("version"))
    	{
    		String msg = config.getString("messages."+arg);
    		return ChatColor.translateAlternateColorCodes('&', msg).replaceAll("%prefix%",Message("prefix", null)).replaceAll("%version%", jao.version);
    	}
    	
    	
    	if(arg.equals("developer"))
    	{
    		String msg = config.getString("messages."+arg);
    		return ChatColor.translateAlternateColorCodes('&', msg).replaceAll("%prefix%",Message("prefix", null)).replaceAll("%developer%",jao.developers.toString());
    	}
    	
    	if(arg.equals("url"))
    	{
    		String msg = config.getString("messages."+arg);
    		return ChatColor.translateAlternateColorCodes('&', msg).replaceAll("%prefix%",Message("prefix", null)).replaceAll("%url%", jao.web);
    	}
    	
    	if(arg.equals("title"))
    	{
    		String msg = config.getString("messages."+arg);
    		return ChatColor.translateAlternateColorCodes('&', msg).replaceAll("%prefix%",Message("prefix", null)).replaceAll("%player%", player.getName());
    	}
    	
    	if(arg.equals("subtitle"))
    	{
    		String msg = config.getString("messages."+arg);
    		return ChatColor.translateAlternateColorCodes('&', msg).replaceAll("%prefix%",Message("prefix", null)).replaceAll("%player%", player.getName());
    	}
    	
    	if(arg.equals("join-message"))
    	{
    		String msg = config.getString("messages."+arg);
    		return ChatColor.translateAlternateColorCodes('&', msg).replaceAll("%prefix%",Message("prefix", null)).replaceAll("%player%", player.getName());
    	}
    	
    	if(arg.equals("no-exist"))
    	{
    		String msg = config.getString("messages."+arg);
    		return ChatColor.translateAlternateColorCodes('&', msg).replaceAll("%prefix%",Message("prefix", null));
    	}
    	
    	
    	if(arg.equals("error-staff"))
    	{
    		String msg = config.getString("messages."+arg);
    		return ChatColor.translateAlternateColorCodes('&', msg).replaceAll("%prefix%",Message("prefix", null));
    	}
    	
    	
    	if(arg.equals("error-user"))
    	{
    		String msg = config.getString("messages."+arg);
    		return ChatColor.translateAlternateColorCodes('&', msg).replaceAll("%prefix%",Message("prefix", null));
    	}
    	
    	
    	if(arg.equals("help"))
    	{
    		String msg = "";
    		msg += ChatColor.translateAlternateColorCodes('&', config.getString("messages.help-header"));
    		msg += "\n";
    		msg += ChatColor.translateAlternateColorCodes('&', config.getString("messages.help-help"));
    		msg += "\n";
    		msg += ChatColor.translateAlternateColorCodes('&', config.getString("messages.help-setspawn"));
    		msg += "\n";
    		msg += ChatColor.translateAlternateColorCodes('&', config.getString("messages.help-spawn"));
    		msg += "\n";
    		msg += ChatColor.translateAlternateColorCodes('&', config.getString("messages.help-reload"));
    		msg += "\n";
    		msg += ChatColor.translateAlternateColorCodes('&', config.getString("messages.help-version"));
    		msg += "\n";
    		msg += ChatColor.translateAlternateColorCodes('&', config.getString("messages.help-developer"));
    		msg += "\n";
    		msg += ChatColor.translateAlternateColorCodes('&', config.getString("messages.help-url"));
    		msg += "\n";
    		msg += ChatColor.translateAlternateColorCodes('&', config.getString("messages.help-footer"));
    		return msg.replaceAll("%prefix%",Message("prefix", null));
    	}
    	
    	
    	
    	
    	
    	return null;
    	
    }



}
