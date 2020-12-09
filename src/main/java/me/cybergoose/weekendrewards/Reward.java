package me.cybergoose.weekendrewards;

import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;

public class Reward implements Listener {

    @EventHandler
    public void onPlayerXP(EntityDeathEvent entityDeathEvent){
        if(!(entityDeathEvent.getEntity().getKiller() instanceof Player)) return;
        Player player= entityDeathEvent.getEntity().getKiller();
        int exp= entityDeathEvent.getDroppedExp();
        player.sendMessage(ChatColor.RED + "" + exp);
        player.sendMessage(ChatColor.GREEN + "" + exp*2);
        entityDeathEvent.setDroppedExp(exp*2);
    }

    @EventHandler
    public void onBlockXP(BlockBreakEvent blockBreakEvent){
        Player player= blockBreakEvent.getPlayer();
        int exp= blockBreakEvent.getExpToDrop();
        player.sendMessage(ChatColor.RED + "" + exp);
        player.sendMessage(ChatColor.GREEN + "" + exp*2);
        blockBreakEvent.setExpToDrop(exp*2);
    }
}
