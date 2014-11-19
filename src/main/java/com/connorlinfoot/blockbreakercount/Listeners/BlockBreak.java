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
        if (itemInHand.getType().toString().toLowerCase().contains("pickaxe") ||
                itemInHand.getType().toString().toLowerCase().contains("axe") ||
                itemInHand.getType().toString().toLowerCase().contains("spade")) {
            ItemMeta itemMeta = itemInHand.getItemMeta();
            String displayName = itemMeta.getDisplayName();
            if (displayName.contains(ChatColor.AQUA + "[") && displayName.contains("]" + ChatColor.BLACK)) {
                int first = displayName.indexOf("[") + 2;
                int last = displayName.indexOf("]");
                int count = Integer.parseInt(displayName.substring(first, displayName.length() - last));
                player.sendMessage(displayName.substring(first, displayName.length() - last));
                int newCount = count + 1;
                displayName = displayName.replaceAll(String.valueOf(count), String.valueOf(newCount));
                itemMeta.setDisplayName(displayName);
                itemInHand.setItemMeta(itemMeta);
                player.getInventory().setItem(player.getInventory().getHeldItemSlot(), itemInHand);
            }
        }
    }

}
