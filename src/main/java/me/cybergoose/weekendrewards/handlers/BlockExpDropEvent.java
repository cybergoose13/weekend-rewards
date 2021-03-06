/*  Title:      Weekend Rewards
 *   Author:     CyberGoose
 *   Start:      7-12-20
 *   Update:     24-12-20
 * */

package me.cybergoose.weekendrewards.handlers;

import me.cybergoose.weekendrewards.interfaces.RewardInterface;
import me.cybergoose.weekendrewards.utils.BlockEnum;
import me.cybergoose.weekendrewards.utils.RewardDay;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

public class BlockExpDropEvent implements Listener, RewardInterface {

    @SuppressWarnings("unused")
    @EventHandler
    public void BlockExpDrop(BlockBreakEvent blockBreakEvent){

        if(!(RewardDay.getDay())) return;
        if(!BlockEnum.contains(blockBreakEvent.getBlock().getType())) return;

        Player player= blockBreakEvent.getPlayer();
        ItemStack mainHand= player.getInventory().getItemInMainHand();
        int dropWeight = 98;

        Map<Enchantment, Integer> enchantmentIntegerMap=
                mainHand.getEnchantments();

        for (Enchantment enchantment : enchantmentIntegerMap.keySet()) {
            if(enchantment == Enchantment.SILK_TOUCH) return;
            if(enchantment == Enchantment.LOOT_BONUS_BLOCKS){
                switch (Objects.requireNonNull(mainHand.getItemMeta()).getEnchantLevel(enchantment)){
                    case 1: dropWeight=- 2; break;
                    case 2: dropWeight=- 4; break;
                    case 3: dropWeight=- 6; break;
                    default: return;
                }
            }
        }

//        if(COOLDOWN.containsKey(player.getUniqueId())){
//            int coolDownTime = 30;
//            long secondsLeft= ((COOLDOWN.get(player.getUniqueId()) / 1000) + coolDownTime) -
//                    (System.currentTimeMillis() / 1000);
//
//            if(secondsLeft > 0) {
//                return;
//            }else{
//                COOLDOWN.remove(player.getUniqueId());
//            }
//        }

        Collection<ItemStack> itemDrops= blockBreakEvent.getBlock().getDrops();
        blockBreakEvent.setExpToDrop(
                (int) Math.round(blockBreakEvent.getExpToDrop() *
                        PLUGIN.getConfig().getDouble("multiplier")));

        if(new Random().nextInt(100) > dropWeight){
            ItemStack dropItem= new Random().nextInt(1 + 1) == 1 ?
                    new ItemStack(Material.DIAMOND) : new ItemStack(Material.EMERALD);
            blockBreakEvent.getBlock().getWorld()
                    .dropItemNaturally(
                            blockBreakEvent.getBlock().getLocation(), dropItem);
        }
    }
}
