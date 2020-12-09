/*  Title:      Weekend Rewards
*   Author:     CyberGoose
*   Start:      7-12-20
*   Update:     7-12-20
*   Version:    Snap-1.0
* */

package me.cybergoose.weekendrewards;

import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class WeekendRewards extends JavaPlugin {

    private final ConsoleCommandSender CONSOLESENDER= this.getServer().getConsoleSender();
    @Override
    public void onEnable() {
        loadConfig();
        this.getServer().getPluginManager().registerEvents(new Reward(), this);
        CONSOLESENDER.sendMessage(ChatColor.GREEN + this.getName() + " is enabled.");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        CONSOLESENDER.sendMessage(ChatColor.RED + this.getName() + " is disabled.");
    }

    private void loadConfig(){
        getConfig().options().copyDefaults(true);
        saveConfig();
    }
}
