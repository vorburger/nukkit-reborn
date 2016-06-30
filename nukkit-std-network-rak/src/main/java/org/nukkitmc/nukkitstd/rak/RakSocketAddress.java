package org.nukkitmc.nukkitstd.rak;

import org.nukkitmc.nukkit.core.io.ClientIdentifier;

import java.net.InetSocketAddress;
import java.util.Objects;

/**
 * Created by Mulan Lin('Snake1999') on 2016/6/8 7:12.
 */
public class RakSocketAddress implements ClientIdentifier{
    private InetSocketAddress address;

    public RakSocketAddress(InetSocketAddress address) {
        this.address = address;
    }

    public InetSocketAddress getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof RakSocketAddress && Objects.equals(this.address, ((RakSocketAddress) obj).address);
    }

    @Override
    public String toString() {
        return "RakSocketAddress@"+address.toString();
    }
}
