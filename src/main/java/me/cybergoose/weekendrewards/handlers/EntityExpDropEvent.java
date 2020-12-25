/*  Title:      Weekend Rewards
 *   Author:     CyberGoose
 *   Start:      7-12-20
 *   Update:     10-12-20
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
        if(!(RewardDay.getDay())) return;
        if(entityDeathEvent.getEntity().getKiller() == null) return;

        entityDeathEvent.setDroppedExp(entityDeathEvent.getDroppedExp()
                * PLUGIN.getConfig().getInt("multiplier"));

        PLUGIN.getServer().getConsoleSender()
                .sendMessage(entityDeathEvent.getEntity().getName() +
                        " dropped " + entityDeathEvent.getDroppedExp() + "xp");

        /*
        *   player and collections are not used.. held here for possible implementation in the future.
        */
        Player player= entityDeathEvent.getEntity().getKiller();
        Collection<ItemStack> items= entityDeathEvent.getDrops();

        if(new Random().nextInt(10 + 1) > 9){
            ItemStack dropItem = new Random().nextInt( 1 + 1) == 1 ?
                    new ItemStack(Material.DIAMOND) : new ItemStack(Material.EMERALD);
            entityDeathEvent.getDrops().add(dropItem);
        }
    }
}
