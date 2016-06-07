package org.nukkitmc.nukkit.core.io;

/**
 * Created by Mulan Lin('Snake1999') on 2016/6/7 10:35.
 */
public interface ClientManager {

    Client getClient(ClientIdentifier id);

    int getClientCount();
}
