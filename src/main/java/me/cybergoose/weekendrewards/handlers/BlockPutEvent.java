/*  Title:      Weekend Rewards
 *   Author:     CyberGoose
 *   Start:      12-12-20
 *   Update:     12-12-20
 * */

package me.cybergoose.weekendrewards.handlers;

import me.cybergoose.weekendrewards.interfaces.RewardInterface;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPutEvent implements Listener, RewardInterface {

    @EventHandler
    public void onBlockPutEvent(BlockPlaceEvent blockPlaceEvent){
        Player player= blockPlaceEvent.getPlayer();
        COOLDOWN.put(player.getUniqueId(), System.currentTimeMillis());
    }
}
