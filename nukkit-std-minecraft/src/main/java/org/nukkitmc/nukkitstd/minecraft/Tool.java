package org.nukkitmc.nukkitstd.minecraft;

/**
 * Created by Mulan Lin('Snake1999') on 2016/6/7 14:35.
 */
public interface Tool {

    ToolMaterial getToolMaterial();

    ToolType getToolType();

    default boolean canUseOn(Tool other) {
        return getToolMaterial().canUseOn(other.getToolMaterial()) && getToolType().canUseOn(other.getToolType());
    }
}
