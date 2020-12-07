package me.cybergoose.weekendrewards;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class WeekendRewards extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + this.getName() + " is enabled.");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
