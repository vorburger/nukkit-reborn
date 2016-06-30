package org.nukkitmc.nukkitstd.rak;

import org.nukkitmc.nukkit.core.io.Client;
import org.nukkitmc.nukkit.core.io.ClientIdentifier;
import org.nukkitmc.nukkit.core.io.ClientManager;
import org.nukkitmc.nukkit.core.io.SourceInterface;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by Mulan Lin('Snake1999') on 2016/6/30 17:15.
 */
class RakClientManager implements ClientManager {

    private ConcurrentMap<ClientIdentifier, Client> map = new ConcurrentHashMap<>();

    RakClient putClient(RakSocketAddress address, SourceInterface sourceInterface) {
        ClientManager manager = this;
        RakClient client = new RakClient(this, sourceInterface, address);
        map.put(address, client);
        return client;
    }

    void removeClient(ClientIdentifier id) {
        map.remove(id);
    }

    @Override
    public Client getClient(ClientIdentifier id) {
        return map.getOrDefault(id, null);
    }

    @Override
    public int getClientCount() {
        return map.size();
    }

    class RakClient implements Client{

        private final ClientManager manager;
        private final SourceInterface sourceInterface;
        private final RakSocketAddress address;

        RakClient(ClientManager manager, SourceInterface sourceInterface, RakSocketAddress address) {
            this.manager = manager;
            this.sourceInterface = sourceInterface;
            this.address = address;
        }
        @Override
        public ClientManager getClientManager() {return manager;}

        @Override
        public SourceInterface getSourceInterface() {return sourceInterface;}

        @Override
        public RakSocketAddress getClientIdentifier() {return address;}

        @Override
        public String toString() {return "RakClient@"+address.toString();}
    }
}
