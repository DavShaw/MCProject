package ssm.simplesafemode;

import ssm.commands.SSMMainCommand;
import ssm.support.LogicFunctions;

import java.io.File;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class SimpleSafeMode extends JavaPlugin
{
	
	//Important variables
	private boolean initialized = false;
	
	//Information variables
	PluginDescriptionFile pdffile = getDescription();
	
	public String version = pdffile.getVersion();
	public String name = pdffile.getName();
	public List<String> developers = pdffile.getAuthors();
	public String web = pdffile.getWebsite();
	public String ConfigPath;
	
	//Color variables
	LogicFunctions color = new LogicFunctions();
	
	
	
	
	public void onEnable()
	{
		if(!initialized)
		{
			initialized = true;
			
			Bukkit.getConsoleSender().sendMessage(color.yellow+"======================================");
			Bukkit.getConsoleSender().sendMessage(String.format(color.green+"Plugin enabled :)"));
			Bukkit.getConsoleSender().sendMessage(String.format(color.green+"Name: %s", name));
			Bukkit.getConsoleSender().sendMessage(String.format(color.green+"Version: %s", version));
			Bukkit.getConsoleSender().sendMessage(String.format(color.green+"Developers: %s", developers));
			Bukkit.getConsoleSender().sendMessage(String.format(color.green+"Plugin URL: %s", web));
			Bukkit.getConsoleSender().sendMessage(color.yellow+"======================================");
			
			CommandRegister();
			EventRegister();
			ConfigRegister();
		}
		
		else
		{
			Bukkit.getConsoleSender().sendMessage(color.red+"SimpleSafeMode already initialized");
		}
		
		
	}
	
	public void onDisable()
	{
		Bukkit.getConsoleSender().sendMessage(color.yellow+"======================================");
		Bukkit.getConsoleSender().sendMessage(String.format(color.red+"Plugin disabled :("));
		Bukkit.getConsoleSender().sendMessage(String.format(color.red+"Name: %s", name));
		Bukkit.getConsoleSender().sendMessage(String.format(color.red+"Version: %s", version));
		Bukkit.getConsoleSender().sendMessage(String.format(color.red+"Developers: %s", developers));
		Bukkit.getConsoleSender().sendMessage(String.format(color.red+"Plugin URL: %s", web));
		Bukkit.getConsoleSender().sendMessage(color.yellow+"======================================");
	}
	
	public void CommandRegister()
	{
		this.getCommand("ssm").setExecutor(new SSMMainCommand(this));
		this.getCommand("simplesafemode").setExecutor(new SSMMainCommand(this));
	}
	
	public void EventRegister()
	{
		
	}
	
	public void ConfigRegister()
	{
		File config = new File(this.getDataFolder(),"config.yml");
		ConfigPath = config.getPath();
		
		//checking if config.yml exist
		if(!config.exists())
		{
			this.getConfig().options().copyDefaults(true);
			saveConfig();
		}
	}
	
	
}
