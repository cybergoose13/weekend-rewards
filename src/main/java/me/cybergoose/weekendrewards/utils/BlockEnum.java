/*  Title:      Weekend Rewards
 *   Author:     CyberGoose
 *   Start:      12-12-20
 *   Update:     24-12-20
 * */

/*  =================================
*   ENUM IS UNUSED CURRENTLY
*   =================================
* */

package me.cybergoose.weekendrewards.utils;

import org.bukkit.Material;

import java.util.ArrayList;
import java.util.List;

public enum BlockEnum {
    GRASS(Material.GRASS),
    GRASSBLOCK(Material.GRASS_BLOCK),
    STONE(Material.STONE),
    GRAVEL(Material.GRAVEL),
    SAND(Material.SAND),
    COAL(Material.COAL_ORE),
    REDSTONE(Material.REDSTONE_ORE),
    LAPIS(Material.LAPIS_ORE),
    QUARTZ(Material.NETHER_QUARTZ_ORE),
    DIAMOND(Material.DIAMOND_ORE);

    private final Material type;

    BlockEnum(Material type){
        this.type= type;
    }

    public Material getType(){
        return this.type;
    }

    public static List<Material> getBlocks(){
        List<Material> blocks= new ArrayList<>();
        for(BlockEnum block : BlockEnum.values()){
            blocks.add(block.type);
        }
        return blocks;
    }

    public static boolean contains(Material material){
        for(BlockEnum block : BlockEnum.values()){
            if(material.equals(block.getType())) return true;
        }
        return false;
    }
}
