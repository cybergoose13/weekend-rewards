/*  Title:      Weekend Rewards
 *   Author:     CyberGoose
 *   Start:      9-12-20
 *   Update:     9-12-20
 *   Version:    Snap-1.0
 *
 *   NOTES:     Dup. of RewardDay.GetDay will be removing this or other...
 * */

package me.cybergoose.weekendrewards.utils;

import me.cybergoose.weekendrewards.interfaces.RewardInterface;

public class ConfigChecker implements RewardInterface {

    private static boolean sunday, monday, tuesday, wednesday, thursday, friday, saturday;
    public void ConfigChecker(){
        sunday= PLUGIN.getConfig().getBoolean("sunday");
        monday= PLUGIN.getConfig().getBoolean("monday");
        tuesday= PLUGIN.getConfig().getBoolean("tuesday");
        wednesday= PLUGIN.getConfig().getBoolean("wednesday");
        thursday= PLUGIN.getConfig().getBoolean("thursday");
        friday= PLUGIN.getConfig().getBoolean("friday");
        saturday= PLUGIN.getConfig().getBoolean("saturday");
    }
}
