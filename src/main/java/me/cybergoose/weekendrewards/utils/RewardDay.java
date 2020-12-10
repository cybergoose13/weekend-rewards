package me.cybergoose.weekendrewards.utils;

import me.cybergoose.weekendrewards.interfaces.RewardInterface;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.Calendar;

public class RewardDay implements RewardInterface {

    public boolean getDay(){

        FileConfiguration config= PLUGIN.getConfig();
        boolean isRewardDay= false;


        switch (Calendar.getInstance().getTime().getDay()){
            case 0:
                isRewardDay= config.getBoolean("days.sunday");
                break;
            case 1:
                isRewardDay= config.getBoolean("days.monday");
                break;
            case 2:
                isRewardDay= config.getBoolean("days.tuesday");
                break;
            case 3:
                isRewardDay= config.getBoolean("days.wednesday");
                break;
            case 4:
                isRewardDay= config.getBoolean("days.thursday");
                break;
            case 5:
                isRewardDay= config.getBoolean("days.friday");
                break;
            case 6:
                isRewardDay= config.getBoolean("days.saturday");
                break;
            default: PLUGIN.getServer().getConsoleSender()
                    .sendMessage("Day could not be found in Weekend Reward");
        }
        return isRewardDay;
    }
}
