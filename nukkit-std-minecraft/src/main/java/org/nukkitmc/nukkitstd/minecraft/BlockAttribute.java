package org.nukkitmc.nukkitstd.minecraft;

/**
 * Created by Mulan Lin('Snake1999') on 2016/6/7 14:28.
 */
public interface BlockAttribute {

    int getBlastResistance();

    int getLightness();

    int getHardness();

    boolean canBurn();

    boolean isTransparent();

    Tool getRequiredTool();

}
