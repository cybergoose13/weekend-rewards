/*  Title:      Weekend Rewards
 *   Author:     CyberGoose
 *   Start:      12-12-20
 *   Update:     12-12-20
 * */

package me.cybergoose.weekendrewards.handlers;

import me.cybergoose.weekendrewards.interfaces.RewardInterface;
import me.cybergoose.weekendrewards.utils.RewardDay;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.FurnaceExtractEvent;

public class CookingExpEvent implements Listener, RewardInterface {

    @EventHandler
    public void onExtractEvent(FurnaceExtractEvent furnaceExtractEvent){
        if(!(new RewardDay().getDay())) return;

        furnaceExtractEvent.setExpToDrop(
                (int) Math.round(furnaceExtractEvent.getExpToDrop() *
                        PLUGIN.getConfig().getDouble("multiplier")));

        furnaceExtractEvent.getPlayer().sendMessage(
                "xp: " + furnaceExtractEvent.getExpToDrop() *
                        PLUGIN.getConfig().getDouble("multiplier"));
    }
}
