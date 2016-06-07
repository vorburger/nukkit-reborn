package org.nukkitmc.nukkit.core.io;

/**
 * Created by Mulan Lin('Snake1999') on 2016/6/8 7:01.
 */
public interface SourceInterface {

    void send(Client client, ClientSendable packet);

    void close(Client client);

    void close(Client client, String reason);

    void shutdown();

    void emergencyShutdown();
}
