package me.cybergoose.weekendrewards.utils;

import me.cybergoose.weekendrewards.interfaces.RewardInterface;
import org.bukkit.plugin.Plugin;

public class ConfigChecker implements RewardInterface {

    private static boolean sunday, monday, tuesday, wednesday, thursday, friday, saturday;
    public void ConfigChecker(){
        sunday= PLUGIN.getConfig().getBoolean("sunday");
        PLUGIN.getServer().getConsoleSender().sendMessage("SUNDAY IN CONFIG IS " + sunday);
    }
}
