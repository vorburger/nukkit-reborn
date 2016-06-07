package org.nukkitmc.nukkitstd.rak.internal;

import cn.nukkit.raknet.server.RakNetServer;
import org.nukkitmc.nukkit.core.io.Client;
import org.nukkitmc.nukkit.core.io.ClientSendable;
import org.nukkitmc.nukkit.core.io.SourceInterface;
import org.nukkitmc.nukkitstd.rak.DataPacket;

import java.net.InetSocketAddress;

/**
 * Created by Mulan Lin('Snake1999') on 2016/6/8 7:02.
 */
public class WrappedRakServer extends RakNetServer implements SourceInterface {
    public WrappedRakServer(InetSocketAddress address) {
        super(address);
    }

    @Override
    public void send(Client client, ClientSendable packet) {
        if (!(packet instanceof DataPacket)) return;
        DataPacket pk = (DataPacket) packet;
    }

    @Override
    public void close(Client client) {

    }

    @Override
    public void close(Client client, String reason) {

    }

    @Override
    public void emergencyShutdown() {

    }
}
