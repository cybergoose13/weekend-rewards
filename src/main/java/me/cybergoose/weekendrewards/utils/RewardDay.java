package me.cybergoose.weekendrewards.utils;

import me.cybergoose.weekendrewards.interfaces.RewardInterface;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.Calendar;

public class RewardDay implements RewardInterface {

    public boolean getDay(){

        FileConfiguration config= PLUGIN.getConfig();
        boolean isRewardDay;

        switch (Calendar.getInstance().getTime().getDay()){
            case 0:
                isRewardDay= config.getBoolean("sunday");
                break;
            case 1:
                isRewardDay= config.getBoolean("monday");
                break;
            case 2:
                isRewardDay= config.getBoolean("tuesday");
                break;
            case 3:
                isRewardDay= config.getBoolean("wednesday");
                break;
            case 4:
                isRewardDay= config.getBoolean("thursday");
                break;
            case 5:
                isRewardDay= config.getBoolean("friday");
                break;
            case 6:
                isRewardDay= config.getBoolean("saturday");
                break;
            default: PLUGIN.getServer().getConsoleSender()
                    .sendMessage("Day could not be found in Weekend Reward");
                isRewardDay= false;
        }
        return isRewardDay;
    }
}
