package org.nukkitmc.nukkitstd.minecraft;

/**
 * Created by Mulan Lin('Snake1999') on 2016/6/8 19:25.
 */
public interface Skin {

    int SINGLE_SKIN_SIZE = 64 * 32 * 4;
    int DOUBLE_SKIN_SIZE = 64 * 64 * 4;

    byte[] getSkinData();

    String getSkinModel();

    default boolean isValid() {
        return getSkinData().length == SINGLE_SKIN_SIZE || getSkinData().length == DOUBLE_SKIN_SIZE;
    }
}
