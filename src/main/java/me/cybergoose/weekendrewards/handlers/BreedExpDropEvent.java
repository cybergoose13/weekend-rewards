/*  Title:      Weekend Rewards
 *   Author:     CyberGoose
 *   Start:      12-12-20
 *   Update:     24-12-20
 * */

package me.cybergoose.weekendrewards.handlers;

import me.cybergoose.weekendrewards.interfaces.RewardInterface;
import me.cybergoose.weekendrewards.utils.RewardDay;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityBreedEvent;

public class BreedExpDropEvent implements Listener, RewardInterface {
    @EventHandler
    public void onBreedEvent(EntityBreedEvent entityBreedEvent){

        if(!(RewardDay.getDay())) return;
        entityBreedEvent.setExperience(
                (int) Math.round(entityBreedEvent.getExperience() *
                        PLUGIN.getConfig().getDouble("multiplier")));
    }
}
