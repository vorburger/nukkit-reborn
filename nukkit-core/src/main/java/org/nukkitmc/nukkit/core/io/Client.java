package org.nukkitmc.nukkit.core.io;

/**
 * Created by Mulan Lin('Snake1999') on 2016/6/7 10:16.
 */
public interface Client {

    ClientManager getClientManager();

    SourceInterface getSourceInterface();

    ClientIdentifier getClientIdentifier();

    default void send(ClientSendable data) {
        getSourceInterface().send(this, data);
    }

    /*default void close(String reason) {
        getSourceInterface().close(this, reason);
    }*/

}
