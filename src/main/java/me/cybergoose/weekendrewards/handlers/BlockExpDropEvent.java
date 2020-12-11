/*  Title:      Weekend Rewards
 *   Author:     CyberGoose
 *   Start:      7-12-20
 *   Update:     10-12-20
 * */

package me.cybergoose.weekendrewards.handlers;

import me.cybergoose.weekendrewards.interfaces.RewardInterface;
import me.cybergoose.weekendrewards.utils.RewardDay;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Collection;
import java.util.Random;

public class BlockExpDropEvent implements Listener, RewardInterface {

    @SuppressWarnings("unused")
    @EventHandler
    public void BlockExpDrop(BlockBreakEvent blockBreakEvent){
        if(!(new RewardDay().getDay())) return;
        Collection<ItemStack> itemDrops= blockBreakEvent.getBlock().getDrops();
        blockBreakEvent.setExpToDrop(blockBreakEvent.getExpToDrop()
                * PLUGIN.getConfig().getInt("multiplier"));

        if(new Random().nextInt(100) > 98){
            ItemStack dropItem= new Random().nextInt(1 + 1) == 1 ?
                    new ItemStack(Material.DIAMOND) : new ItemStack(Material.EMERALD);
            blockBreakEvent.getBlock().getWorld()
                    .dropItemNaturally(
                            blockBreakEvent.getBlock().getLocation(), dropItem);
        }
    }
}