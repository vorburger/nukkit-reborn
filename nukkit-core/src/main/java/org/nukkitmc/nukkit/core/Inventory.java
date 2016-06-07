package org.nukkitmc.nukkit.core;

/**
 * Created by Mulan Lin('Snake1999') on 2016/6/7 9:57.
 */
public interface Inventory {

    InventoryHolder getInventoryHolder();

    Slot[] toSlots();

}
