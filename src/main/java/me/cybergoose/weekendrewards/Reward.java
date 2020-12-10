package me.cybergoose.weekendrewards;

import me.cybergoose.weekendrewards.interfaces.RewardInterface;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Calendar;
import java.util.List;

public class Reward implements Listener, RewardInterface {

    @EventHandler
    public void onPlayerXP(EntityDeathEvent entityDeathEvent){
        if(!(entityDeathEvent.getEntity().getKiller() instanceof Player)) return;
        Player player= entityDeathEvent.getEntity().getKiller();
        int exp= entityDeathEvent.getDroppedExp();
        player.sendMessage(ChatColor.RED + entityDeathEvent.getEntity().getName() + " dropped " + exp + "xp");
        player.sendMessage(ChatColor.GREEN + "Drop after double xp: " + exp*2);
        entityDeathEvent.setDroppedExp(exp*2);
        List<ItemStack> itemStack= entityDeathEvent.getDrops();

    }

    @EventHandler
    public void onBlockXP(BlockBreakEvent blockBreakEvent){
        if(!(blockBreakEvent.getPlayer() instanceof Player)) return;
        Player player= blockBreakEvent.getPlayer();
        int exp= blockBreakEvent.getExpToDrop();
        player.sendMessage(ChatColor.RED + blockBreakEvent.getBlock().getType().toString() + " dropped " + exp);
        player.sendMessage(ChatColor.GREEN + "Drop after double xp: " + exp*2);
        blockBreakEvent.setExpToDrop(exp*2);
    }

    public int getDay(){
        FileConfiguration config= PLUGIN.getConfig();
        switch (Calendar.getInstance().getTime().getDay()){
            case 0:
                config.getBoolean("sunday");
                break;
            case 1:
                config.getBoolean("monday");
                break;
            case 2:
                config.getBoolean("tuesday");
                break;
            case 3:
                config.getBoolean("wednesday");
                break;
            case 4:
                config.getBoolean("thursday");
                break;
            case 5:
                config.getBoolean("friday");
                break;
            case 6:
                config.getBoolean("saturday");
                break;
            default: PLUGIN.getServer().getConsoleSender()
                    .sendMessage("Day could not be found in Weekend Reward");
        }
        return Calendar.getInstance().getTime().getDay();
    }
}
