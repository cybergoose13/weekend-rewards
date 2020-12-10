/*  Title:      Weekend Rewards
 *   Author:     CyberGoose
 *   Start:      7-12-20
 *   Update:     9-12-20
 *   Version:    Snap-1.0
 * */

package me.cybergoose.weekendrewards.handlers;

import me.cybergoose.weekendrewards.interfaces.RewardInterface;
import me.cybergoose.weekendrewards.utils.ConfigChecker;
import me.cybergoose.weekendrewards.utils.RewardDay;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Collection;

public class BlockExpDrop implements Listener, RewardInterface {

    @EventHandler
    public void BlockExpDrop(BlockBreakEvent blockBreakEvent){
        if(!(new RewardDay().getDay())) return;
        Collection<ItemStack> itemDrops= blockBreakEvent.getBlock().getDrops();
        for (ItemStack item: itemDrops) {
            PLUGIN.getServer().getConsoleSender().sendMessage(item.getType().name());
        }
        blockBreakEvent.setExpToDrop(blockBreakEvent.getExpToDrop() * 2);
    }
}
