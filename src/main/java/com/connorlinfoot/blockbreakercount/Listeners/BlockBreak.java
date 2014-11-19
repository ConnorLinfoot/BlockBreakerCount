package com.connorlinfoot.blockbreakercount.Listeners;

import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class BlockBreak implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        Block block = event.getBlock();
        ItemStack itemInHand = player.getItemInHand();
        if (itemInHand == null || itemInHand.getType() == null) return;
        if (itemInHand.getItemMeta().getDisplayName() == null) return;
        player.sendMessage("1");
        if (itemInHand.getType().toString().toLowerCase().contains("pickaxe") ||
                itemInHand.getType().toString().toLowerCase().contains("axe") ||
                itemInHand.getType().toString().toLowerCase().contains("spade")) {
            player.sendMessage("2");
            ItemMeta itemMeta = itemInHand.getItemMeta();
            String displayName = itemMeta.getDisplayName();
            if (displayName.contains(ChatColor.AQUA + "[")) {
                player.sendMessage("3");
                player.sendMessage(displayName);
                player.sendMessage(String.valueOf(displayName.indexOf("[") + 1));
                int first = displayName.indexOf("[") + 1;
                //player.sendMessage(String.valueOf(displayName.indexOf("]") + 1));
                //int last = displayName.indexOf("]") + 1;
                player.sendMessage(displayName.substring(first).replaceAll("]", ""));
                int count = Integer.parseInt(displayName.substring(first).replaceAll("]", ""));

                int newCount = count + 1;
                displayName = displayName.replaceAll(String.valueOf(count), String.valueOf(newCount));
                itemMeta.setDisplayName(displayName);
                itemInHand.setItemMeta(itemMeta);
                player.getInventory().setItem(player.getInventory().getHeldItemSlot(), itemInHand);
            }
        }
    }

}
