/*  Title:      Weekend Rewards
*   Author:     CyberGoose
*   Start:      7-12-20
*   Update:     10-12-20
*   Version:    1.0
* */

package me.cybergoose.weekendrewards;

import me.cybergoose.weekendrewards.handlers.BlockExpDropEvent;
import me.cybergoose.weekendrewards.handlers.EntityExpDropEvent;
import me.cybergoose.weekendrewards.handlers.PlayerJoinEvent;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class WeekendRewards extends JavaPlugin {

    private final ConsoleCommandSender CONSOLE_SENDER = this.getServer().getConsoleSender();

    @Override
    public void onEnable() {
        loadConfig();
        this.getServer().getPluginManager().registerEvents(new BlockExpDropEvent(), this);
        this.getServer().getPluginManager().registerEvents(new EntityExpDropEvent(), this);
        this.getServer().getPluginManager().registerEvents(new PlayerJoinEvent(), this);
        CONSOLE_SENDER.sendMessage(ChatColor.GREEN + this.getName() + " is enabled.");
    }

    @Override
    public void onDisable() {
        CONSOLE_SENDER.sendMessage(ChatColor.RED + this.getName() + " is disabled.");
    }

    private void loadConfig(){
        getConfig().options().copyDefaults(true);
        saveConfig();
        reloadConfig();
    }
}
