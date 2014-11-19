package com.connorlinfoot.blockbreakercount;

import com.connorlinfoot.blockbreakercount.Commands.BBCCommand;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;


public class BlockBreakerCount extends JavaPlugin implements Listener {
    private static Plugin plugin;
    public static boolean SNAPSHOT = false;
    public static String Prefix = "[BlockBreakerCount] ";

    public void onEnable() {
        plugin = this;
        getConfig().options().copyDefaults(true);
        saveConfig();
        Server server = getServer();
        ConsoleCommandSender console = server.getConsoleSender();

        console.sendMessage("");
        console.sendMessage(ChatColor.BLUE + "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        console.sendMessage("");
        console.sendMessage(ChatColor.AQUA + getDescription().getName());
        console.sendMessage(ChatColor.AQUA + "Version " + getDescription().getVersion());
        if (getDescription().getVersion().contains("SNAPSHOT")) {
            SNAPSHOT = true;
            console.sendMessage(ChatColor.RED + "You are running a snapshot build of " + getDescription().getName() + " please report bugs!");
            console.sendMessage(ChatColor.RED + "NO support will be given if running old snapshot build!");
        }
        console.sendMessage("");
        console.sendMessage(ChatColor.BLUE + "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        console.sendMessage("");

        registerCommands(console);
    }

    public void onDisable() {
        getLogger().info(getDescription().getName() + " has been disabled!");
    }

    public static Plugin getPlugin() {
        return plugin;
    }

    private void registerCommands(ConsoleCommandSender console){
        getCommand("bbc").setExecutor(new BBCCommand());
        console.sendMessage(Prefix + "Commands have been registered");
    }
}
