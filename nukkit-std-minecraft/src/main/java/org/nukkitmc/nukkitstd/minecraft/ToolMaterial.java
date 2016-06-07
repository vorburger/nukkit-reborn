package org.nukkitmc.nukkitstd.minecraft;

/**
 * Created by Mulan Lin('Snake1999') on 2016/6/7 14:35.
 */
public enum ToolMaterial {
    ANY(0),
    WOOD(1),
    STONE(2),
    IRON(3),
    GOLD(4),
    DIAMOND(5);
    int level;
    ToolMaterial(int level) {
        this.level = level;
    }

    public boolean canUseOn(ToolMaterial required) {
        return this.level >= required.level;
    }
}
