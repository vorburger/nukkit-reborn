package org.nukkitmc.nukkitstd.rak;

import cn.nukkit.raknet.protocol.EncapsulatedPacket;
import cn.nukkit.raknet.server.RakNetServer;
import cn.nukkit.raknet.server.ServerHandler;
import cn.nukkit.raknet.server.ServerInstance;
import org.nukkitmc.nukkit.core.io.Client;
import org.nukkitmc.nukkit.core.io.ClientSendable;
import org.nukkitmc.nukkit.core.io.SourceInterface;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Mulan Lin('Snake1999') on 2016/6/8 7:02.
 */
class RakServer extends RakNetServer implements SourceInterface, ServerInstance {

    private RakNetServer raknet;
    private ServerHandler handler;
    private RakClientManager clientManager = new RakClientManager();
    private Map<String, RakSocketAddress> rakIdentified = new ConcurrentHashMap<>();

    public RakServer(InetSocketAddress address) {
        super(address);
        this.raknet = new RakNetServer(address);
        this.handler = new ServerHandler(this.raknet, this);
    }

    @Override
    public void send(Client client, ClientSendable sendable) {
        if (!(client.getClientIdentifier() instanceof RakSocketAddress)) return;
        InetSocketAddress address = ((RakSocketAddress) client.getClientIdentifier()).getAddress();
        byte[] buffer = sendable.toByteArray();
        handler.sendRaw(address.getHostName(), address.getPort(), buffer);
    }

    @Override
    public void shutdown() {
        this.handler.shutdown();
    }

    @Override
    public void emergencyShutdown() {
        this.handler.emergencyShutdown();
    }

    @Override
    public void openSession(String rakIdentifier, String addressString, int port, long clientID) {
        try {
            InetSocketAddress address = new InetSocketAddress(InetAddress.getByName(addressString), port);
            RakClientManager.RakClient client = clientManager.putClient(new RakSocketAddress(address), this);
            rakIdentified.put(rakIdentifier, client.getClientIdentifier());
        } catch (UnknownHostException ignore) {}
    }

    @Override
    public void closeSession(String rakIdentifier, String reason) {
        clientManager.removeClient(rakIdentified.getOrDefault(rakIdentifier, null));
    }

    @Override
    public void handleEncapsulated(String rakIdentifier, EncapsulatedPacket packet, int flags) {
        if (!rakIdentified.containsKey(rakIdentifier)) return;
        RakSocketAddress identifier = rakIdentified.get(rakIdentifier);
        DataPacket pk = null;
        try {
            if (packet.buffer.length > 0) {
                /*pk = this.getPacket(packet.buffer);
                if (pk != null) {
                    pk.decode();
                    //player handle data packet
                }*/
            }
        } catch (Exception e) {
            /*this.server.getLogger().logException(e);
            if (Nukkit.DEBUG > 1 && pk != null) {
                MainLogger logger = this.server.getLogger();
//                    if (logger != null) {
                logger.debug("Packet " + pk.getClass().getName() + " 0x" + Binary.bytesToHexString(packet.buffer));
                //logger.logException(e);
//                    }
            }*/

            this.handler.blockAddress(identifier.getAddress().getHostName(), 5);
        }

    }

    @Override
    public void handleRaw(String address, int port, byte[] payload) {
        //// TODO: 2016/6/30  
    }

    @Override
    public void notifyACK(String identifier, int identifierACK) {

    }

    @Override
    public void handleOption(String option, String value) {

    }

}
