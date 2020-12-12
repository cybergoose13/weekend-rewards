/*  Title:      Weekend Rewards
 *   Author:     CyberGoose
 *   Start:      12-12-20
 *   Update:     12-12-20
 * */

/*  =================================
*   ENUM IS UNUSED CURRENTLY
*   =================================
* */

package me.cybergoose.weekendrewards.utils;

import org.bukkit.Material;

public enum BlockEnum {
    GRASS(Material.GRASS),
    STONE(Material.STONE);

    private final Material type;

    BlockEnum(Material type){
        this.type= type;
    }
}
