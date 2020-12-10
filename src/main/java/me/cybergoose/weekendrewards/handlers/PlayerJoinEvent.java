/*  Title:      Weekend Rewards
 *   Author:     CyberGoose
 *   Start:      10-12-20
 *   Update:     10-12-20
 *   Version:    1.0
 * */

package me.cybergoose.weekendrewards.handlers;

import me.cybergoose.weekendrewards.interfaces.RewardInterface;
import me.cybergoose.weekendrewards.utils.RewardDay;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerJoinEvent implements Listener, RewardInterface {

    @EventHandler
    public void PlayerJoin(org.bukkit.event.player.PlayerJoinEvent playerJoinEvent){
        if(new RewardDay().getDay()){
            Player player= playerJoinEvent.getPlayer();
            player.sendMessage(ChatColor
                    .translateAlternateColorCodes('&',
                            "&aXP &7and &bDiamond &dDrops"));
        }
    }
}
