package org.nukkitmc.nukkit.core;

/**
 * Created by Mulan Lin('Snake1999') on 2016/6/7 9:35.
 */
public interface Slot {

    ItemIdentifier getItemIdentifier();

    int getItemCount();

    EnchantmentEntry[] getEnchantments();

}
