/*  Title:      Weekend Rewards
 *   Author:     CyberGoose
 *   Start:      7-12-20
 *   Update:     9-12-20
 *   Version:    Snap-1.0
 * */

package me.cybergoose.weekendrewards.handlers;

import me.cybergoose.weekendrewards.interfaces.RewardInterface;
import me.cybergoose.weekendrewards.utils.RewardDay;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Collection;

public class EntityExpDrop implements Listener, RewardInterface {
    @EventHandler
    public void EntityExpDrop(EntityDeathEvent entityDeathEvent){
        if(!(new RewardDay().getDay())) return;
        if(entityDeathEvent.getEntity().getKiller() == null) return;
        Player player= entityDeathEvent.getEntity().getKiller();
        entityDeathEvent.setDroppedExp(entityDeathEvent.getDroppedExp() *2);
        Collection<ItemStack> items= entityDeathEvent.getDrops();
        for (ItemStack item: items) {
            player.sendMessage(item.getType().name());
        }
    }
}
