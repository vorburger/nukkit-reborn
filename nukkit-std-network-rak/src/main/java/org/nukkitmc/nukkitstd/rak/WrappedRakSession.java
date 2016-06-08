package org.nukkitmc.nukkitstd.rak;

import org.nukkitmc.nukkit.core.io.*;

import java.net.InetAddress;

/**
 * Created by Mulan Lin('Snake1999') on 2016/6/8 6:58.
 */
public class WrappedRakSession implements Client {

    WrappedInetAddress address;

    WrappedRakSession(InetAddress address) {
        this.address = new WrappedInetAddress(address);
    }

    @Override
    public ClientManager getClientManager() {
        return null;
    }

    @Override
    public SourceInterface getSourceInterface() {
        return null;
    }

    @Override
    public ClientIdentifier getClientIdentifier() {
        return address;
    }
}
