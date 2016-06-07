package org.nukkitmc.nukkitstd.rak.internal;

import org.nukkitmc.nukkit.core.io.ClientIdentifier;

import java.net.InetAddress;
import java.util.Objects;

/**
 * Created by Mulan Lin('Snake1999') on 2016/6/8 7:12.
 */
public class WrappedInetAddress implements ClientIdentifier{
    private InetAddress address;

    public WrappedInetAddress(InetAddress address) {
        this.address = address;
    }

    public InetAddress getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof WrappedInetAddress && Objects.equals(this, obj);
    }
}
