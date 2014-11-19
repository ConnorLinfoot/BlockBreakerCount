package com.connorlinfoot.blockbreakercount.Commands;

import com.connorlinfoot.blockbreakercount.BlockBreakerCount;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class BBCCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage(ChatColor.AQUA + "\"" + BlockBreakerCount.getPlugin().getDescription().getName() + "\" - Version: " + BlockBreakerCount.getPlugin().getDescription().getVersion());
        return false;
    }

}
