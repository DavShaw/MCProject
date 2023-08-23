package org.kingxrp.chatquery;

import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;
import org.kingxrp.commands.VoidQuery;
import org.kingxrp.external.DataBase;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;

public final class ChatQuery extends JavaPlugin
{

    private DataBase database;

    @Override
    public void onEnable()
    {
        getComponentLogger().info(Component.text("ChatQuery ha sido activado con éxtio", NamedTextColor.GREEN));
        this.startDataBase();
        this.CommandLoader();
    }

    @Override
    public void onDisable()
    {
        getComponentLogger().info(Component.text("ChatQuery ha sido desactivado con éxtio", NamedTextColor.RED));
        this.stopDataBase();
    }

    private void startDataBase()
    {
        this.database = new DataBase
        (
            "containers-us-west-43.railway.app",
            5490,
            "railway",
            "root",
            "D68rnpSsZji7j5SWyEDo"
        );

        getComponentLogger().info(Component.text("Conexión con la base de datos establecida", NamedTextColor.AQUA));
    }

    private void stopDataBase()
    {
        this.database.disconnect();
        getComponentLogger().info(Component.text("Desconexión con la base de datos establecida", NamedTextColor.BLUE));
    }

    private void CommandLoader()
    {
        this.getCommand("cq").setExecutor(new VoidQuery(this));
    }
    
}
