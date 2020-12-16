/*  Title:      Weekend Rewards
 *   Author:     CyberGoose
 *   Start:      7-12-20
 *   Update:     15-12-20
 * */

package me.cybergoose.weekendrewards.handlers;

import me.cybergoose.weekendrewards.interfaces.RewardInterface;
import me.cybergoose.weekendrewards.utils.RewardDay;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Collection;
import java.util.Map;
import java.util.Random;

public class BlockExpDropEvent implements Listener, RewardInterface {

    private final int cooldowntime= 30;
    @SuppressWarnings("unused")
    @EventHandler
    public void BlockExpDrop(BlockBreakEvent blockBreakEvent){
        if(!(new RewardDay().getDay())) return;

        Player player= blockBreakEvent.getPlayer();

        if(COOLDOWN.containsKey(player.getUniqueId())){
            long secondsLeft= ((COOLDOWN.get(player.getUniqueId()) / 1000) + cooldowntime) -
                    (System.currentTimeMillis() / 1000);

            if(secondsLeft > 0) {
                return;
            }else{
                COOLDOWN.remove(player.getUniqueId());
            }
        }

        Map<Enchantment, Integer> enchantmentIntegerMap=
                blockBreakEvent.getPlayer().getInventory().getItemInMainHand().getEnchantments();

        for (Enchantment enchantment : enchantmentIntegerMap.keySet()) {
            if(enchantment == Enchantment.SILK_TOUCH) return;
        }

        Collection<ItemStack> itemDrops= blockBreakEvent.getBlock().getDrops();
        blockBreakEvent.setExpToDrop(
                (int) Math.round(blockBreakEvent.getExpToDrop() *
                        PLUGIN.getConfig().getDouble("multiplier")));

        if(blockBreakEvent.getBlock().getType() != Material.GRASS) return;

        if(new Random().nextInt(100) > 98){
            ItemStack dropItem= new Random().nextInt(1 + 1) == 1 ?
                    new ItemStack(Material.DIAMOND) : new ItemStack(Material.EMERALD);
            blockBreakEvent.getBlock().getWorld()
                    .dropItemNaturally(
                            blockBreakEvent.getBlock().getLocation(), dropItem);
        }
    }
}
