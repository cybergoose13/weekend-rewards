/*  Title:      Weekend Rewards
 *   Author:     CyberGoose
 *   Start:      9-12-20
 *   Update:     12-12-20
 *   Version:    1.2.0
 * */

package me.cybergoose.weekendrewards.interfaces;

import me.cybergoose.weekendrewards.WeekendRewards;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

@SuppressWarnings("unused")
public interface RewardInterface {
    JavaPlugin PLUGIN= WeekendRewards.getPlugin(WeekendRewards.class);
    String PLUGIN_NAME= PLUGIN.getName();
    HashMap<UUID, Long> COOLDOWN= new HashMap<UUID, Long>();
}
