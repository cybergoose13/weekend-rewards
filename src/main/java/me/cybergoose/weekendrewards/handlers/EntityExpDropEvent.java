/*  Title:      Weekend Rewards
 *   Author:     CyberGoose
 *   Start:      7-12-20
 *   Update:     10-12-20
 *   Version:    Snap-1.0
 * */

package me.cybergoose.weekendrewards.handlers;

import me.cybergoose.weekendrewards.interfaces.RewardInterface;
import me.cybergoose.weekendrewards.utils.RewardDay;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Collection;
import java.util.Random;

public class EntityExpDropEvent implements Listener, RewardInterface {

    @SuppressWarnings("unused")
    @EventHandler
    public void EntityExpDrop(EntityDeathEvent entityDeathEvent){
        if(!(new RewardDay().getDay())) return;
        if(entityDeathEvent.getEntity().getKiller() == null) return;

        entityDeathEvent.setDroppedExp(entityDeathEvent.getDroppedExp()
                * PLUGIN.getConfig().getInt("multiplier"));
        Player player= entityDeathEvent.getEntity().getKiller();

        Collection<ItemStack> items= entityDeathEvent.getDrops();
        if(new Random().nextInt(11) > 8){
            entityDeathEvent.getDrops().add(new ItemStack(Material.DIAMOND));
        }
    }
}
