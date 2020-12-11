/*  Title:      Weekend Rewards
 *   Author:     CyberGoose
 *   Start:      9-12-20
 *   Update:     10-12-20
 *   Version:    Snap-1.0
 * */

package me.cybergoose.weekendrewards.interfaces;

import me.cybergoose.weekendrewards.WeekendRewards;
import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings("unused")
public interface RewardInterface {
    JavaPlugin PLUGIN= WeekendRewards.getPlugin(WeekendRewards.class);
    String PLUGIN_NAME= PLUGIN.getName();

}
