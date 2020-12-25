/*  Title:      Weekend Rewards
 *   Author:     CyberGoose
 *   Start:      12-12-20
 *   Update:     15-12-20
 * */

package me.cybergoose.weekendrewards.handlers;

import me.cybergoose.weekendrewards.interfaces.RewardInterface;
import me.cybergoose.weekendrewards.utils.RewardDay;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPutEvent implements Listener, RewardInterface {

    @EventHandler
    public void onBlockPutEvent(BlockPlaceEvent blockPlaceEvent){

        if(!(RewardDay.getDay())) return;

        Player player= blockPlaceEvent.getPlayer();
        if(blockPlaceEvent.getBlock().getType() == Material.TORCH ||
                blockPlaceEvent.getBlock().getType() == Material.SOUL_TORCH) return;
        COOLDOWN.put(player.getUniqueId(), System.currentTimeMillis());
    }
}
