package org.kingxrp.commands;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.kingxrp.chatquery.ChatQuery;

public class VoidQuery implements CommandExecutor
{

    private final ChatQuery plugin;
    public VoidQuery(ChatQuery plugin)
    {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand
        (
            @NotNull CommandSender sender,
            @NotNull Command command,
            @NotNull String label,
            @NotNull String[] args
        )
        {
            try
            {
                if (args[0].equalsIgnoreCase("voidquery"))
                {
                    sender.sendMessage("VoidQuery executed successfully");
                    return true;
                }
            return false;
            }
            catch (IndexOutOfBoundsException error)
            {
                sender.sendMessage("Error: no existe este subcmd");
                return false;
            } 
        }

}
