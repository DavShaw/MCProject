package ja.joinactions;

import java.io.File;
import java.util.List;


import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import ja.commands.MainCommand;
import ja.events.onDeath;
import ja.events.onFall;
import ja.events.onJoin;
import ja.events.onMove;

import org.bukkit.ChatColor;

public class JoinActions extends JavaPlugin
{
	//Information variables
	public PluginDescriptionFile pdffile = getDescription();
	public String version = pdffile.getVersion();
	public String name = pdffile.getName();
	public List<String> developers = pdffile.getAuthors();
	public String web = pdffile.getWebsite();
	public String ConfigPath;
	
	
	private static JoinActions instance;
    public static JoinActions getInstance()
    {
        return instance;
    }

	
	public void onEnable()
	{
		instance = this;
		
		Bukkit.getConsoleSender().sendMessage(String.format("%s=========[ %s (%s) %s]=========", ChatColor.GRAY,name,version,ChatColor.GRAY));
		Bukkit.getConsoleSender().sendMessage(String.format(ChatColor.GREEN + "Plugin has been enabled successfully :)"));
		Bukkit.getConsoleSender().sendMessage(String.format(ChatColor.GREEN + "Developers: %s", developers));
		Bukkit.getConsoleSender().sendMessage(String.format(ChatColor.GREEN + "Plugin URL: %s", web));
		Bukkit.getConsoleSender().sendMessage(String.format("%s=========[ %s (%s) %s]=========", ChatColor.GRAY,name,version,ChatColor.GRAY));
		
		EventRegister();
		CommandRegister();
		ConfigRegister();
		
	}
	
	
	
	
	
	public void onDisable()
	{
		
		Bukkit.getConsoleSender().sendMessage(String.format("%s=========[ %s (%s) %s]=========", ChatColor.GRAY,name,version,ChatColor.GRAY));
		Bukkit.getConsoleSender().sendMessage(String.format(ChatColor.RED + "Plugin has been disabled successfully :("));
		Bukkit.getConsoleSender().sendMessage(String.format(ChatColor.RED + "Developers: %s", developers));
		Bukkit.getConsoleSender().sendMessage(String.format(ChatColor.RED + "Plugin URL: %s", web));
		Bukkit.getConsoleSender().sendMessage(String.format("%s=========[ %s (%s) %s]=========", ChatColor.GRAY,name,version,ChatColor.GRAY));
		
	}
	
	
	
	
	
	public void EventRegister()
	{
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new onJoin(), this);	
		pm.registerEvents(new onDeath(), this);	
		pm.registerEvents(new onMove(), this);	
		pm.registerEvents(new onFall(), this);	
	}
	
	
	
	
	public void CommandRegister()
	{
		this.getCommand("ja").setExecutor(new MainCommand());
		this.getCommand("joinactions").setExecutor(new MainCommand());
	}
	
	
	
	public void ConfigRegister()
	{
		File config = new File(this.getDataFolder(),"config.yml");
		ConfigPath = config.getPath();
		if(!config.exists())
		{
			this.getConfig().options().copyDefaults(true);
			saveDefaultConfig();
		}
	}
	
	
	
	
	
}
