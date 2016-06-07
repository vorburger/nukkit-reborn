package org.nukkitmc.nukkitstd.mcpe.general;

/**
 * Created by Mulan Lin('Snake1999') on 2016/6/7 9:57.
 */
public interface Inventory {

    InventoryHolder getInventoryHolder();

    Slot[] toSlots();

}
