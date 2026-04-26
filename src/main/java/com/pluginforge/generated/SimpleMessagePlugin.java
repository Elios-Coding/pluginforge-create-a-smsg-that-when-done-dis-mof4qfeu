package com.pluginforge.generated;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.ChatColor;

public class SimpleMessagePlugin extends JavaPlugin implements Listener {

    private String simpleMessage;
    private String senderName;

    @Override
    public void onEnable() {
        // Save default config if not exists
        saveDefaultConfig();
        
        // Load values from config
        simpleMessage = ChatColor.translateAlternateColorCodes('&', getConfig().getString("simple-message", "Confirmed"));
        senderName = ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', getConfig().getString("sender-name", "Test")));

        // Register command executor
        this.getCommand("smsg").setExecutor(this);
        // Register event listener
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("SimpleMessagePlugin has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("SimpleMessagePlugin has been disabled!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("smsg")) {
            if (sender.hasPermission("simplemessageplugin.smsg")) {
                String formattedMessage = String.format("<%s> %s", senderName, simpleMessage);
                getServer().broadcastMessage(formattedMessage);
                return true;
            } else {
                sender.sendMessage(ChatColor.RED + "You do not have permission to use this command.");
                return false;
            }
        }
        return false;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.sendMessage(ChatColor.GREEN + "Welcome to the server! Use /smsg to see a special message.");
    }
}