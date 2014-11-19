package com.connorlinfoot.blockbreakercount.Commands;

import com.connorlinfoot.blockbreakercount.BlockBreakerCount;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class BBCCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length >= 1 && args[0].equalsIgnoreCase("item") && sender instanceof Player && sender.isOp()) {
            Player player = (Player) sender;
            ItemStack itemStack = new ItemStack(Material.DIAMOND_PICKAXE);
            ItemMeta itemMeta = itemStack.getItemMeta();
            itemMeta.setDisplayName(ChatColor.WHITE + "Diamond Pickaxe " + ChatColor.AQUA + "[" + 0 + "]" + ChatColor.BLACK);
            itemStack.setItemMeta(itemMeta);

            player.getInventory().addItem(itemStack);
            player.sendMessage("Test item has been given");
            return true;
        }
        sender.sendMessage(ChatColor.AQUA + "\"" + BlockBreakerCount.getPlugin().getDescription().getName() + "\" - Version: " + BlockBreakerCount.getPlugin().getDescription().getVersion());
        return true;
    }

}
