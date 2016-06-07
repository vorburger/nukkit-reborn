package org.nukkitmc.nukkitstd.minecraft;

/**
 * Created by Mulan Lin('Snake1999') on 2016/6/7 14:36.
 */
public enum ToolType {
    SWORD,
    AXE,
    PICKAXE,
    SHOVEL,
    NONE;

    public boolean canUseOn(ToolType required) {
        return required == NONE || this.equals(required);
    }
}
