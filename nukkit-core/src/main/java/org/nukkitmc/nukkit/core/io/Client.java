package org.nukkitmc.nukkit.core.io;

/**
 * Created by Mulan Lin('Snake1999') on 2016/6/7 10:16.
 */
public interface Client {

    ClientManager getClientManager();

    void send(ClientSendable msg);

    void close(String reason);

}
