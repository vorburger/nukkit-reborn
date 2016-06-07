package org.nukkitmc.nukkitstd.mcpe.general;

import org.nukkitmc.nukkit.core.io.Client;

/**
 * Created by Mulan Lin('Snake1999') on 2016/6/7 10:17.
 */
public interface Player {

    Client asClient();

    InventoryHolder asInventoryHolder();

    //EntityPlayer asEntity();

    //CommandSender asCommandSender();

}
