package org.nukkitmc.nukkit.core.io;

/**
 * Created by Mulan Lin('Snake1999') on 2016/6/8 7:01.
 */
public interface SourceInterface {

    void send(Client client, ClientSendable packet);

    void shutdown();

    void emergencyShutdown();
}
