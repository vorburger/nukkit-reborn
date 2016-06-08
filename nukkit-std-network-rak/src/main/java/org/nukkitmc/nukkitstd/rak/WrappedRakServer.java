package org.nukkitmc.nukkitstd.rak;

import cn.nukkit.raknet.RakNet;
import cn.nukkit.raknet.protocol.EncapsulatedPacket;
import cn.nukkit.raknet.server.RakNetServer;
import cn.nukkit.raknet.server.ServerHandler;
import cn.nukkit.raknet.server.ServerInstance;
import cn.nukkit.utils.Binary;
import org.nukkitmc.nukkit.core.io.Client;
import org.nukkitmc.nukkit.core.io.ClientSendable;
import org.nukkitmc.nukkit.core.io.SourceInterface;

import java.net.InetSocketAddress;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Mulan Lin('Snake1999') on 2016/6/8 7:02.
 */
class WrappedRakServer extends RakNetServer implements SourceInterface, ServerInstance {

    private RakNetServer raknet;

    private ServerHandler handler;

    public WrappedRakServer(InetSocketAddress address) {
        super(address);
        this.raknet = new RakNetServer(address);
        this.handler = new ServerHandler(this.raknet, this);
    }

    @Override
    public Integer send(Client client, ClientSendable sendable) {
        if (!(sendable instanceof DataPacket)) return null;
        DataPacket packet = (DataPacket) sendable;
        return send0(client, packet, false); // TODO: 2016/6/8  
    }
/*
    private Integer send0(Client client, DataPacket packet, boolean immediate) {
        byte[] buffer = packet.getBuffer();
        EncapsulatedPacket pk = null;
        if (!packet.isEncoded()) {
            packet.encode();
            buffer = packet.getBuffer();
        } else {
            if (packet.encapsulatedPacket == null) {
                packet.encapsulatedPacket = new CacheEncapsulatedPacket();
                packet.encapsulatedPacket.identifierACK = null;
                packet.encapsulatedPacket.buffer = Binary.appendBytes((byte) 0x8e, buffer);
                if (packet.getChannel() != 0) {
                    packet.encapsulatedPacket.reliability = 3;
                    packet.encapsulatedPacket.orderChannel = packet.getChannel();
                    packet.encapsulatedPacket.orderIndex = 0;
                } else {
                    packet.encapsulatedPacket.reliability = 2;
                }
            }
            pk = packet.encapsulatedPacket;
        }



        if (!immediate && packet.pid() != ProtocolInfo.BATCH_PACKET && Network.BATCH_THRESHOLD >= 0 && buffer != null && buffer.length >= Network.BATCH_THRESHOLD) {
            this.server.batchPackets(new Player[]{player}, new DataPacket[]{packet}, true);
            return null;
        }


        if (pk == null) {
            pk = new EncapsulatedPacket();
            pk.buffer = Binary.appendBytes((byte) 0x8e, buffer);
            if (packet.getChannel() != 0) {
                packet.reliability = 3;
                packet.orderChannel = packet.getChannel();
                packet.orderIndex = 0;
            } else {
                packet.reliability = 2;
            }
        }

        this.handler.sendEncapsulated(identifier, pk, (immediate ? RakNet.PRIORITY_IMMEDIATE : RakNet.PRIORITY_NORMAL));

        return pk.identifierACK;
    }
/*
    @Override
    public void close(Client client) {

    }

    @Override
    public void close(Client client, String reason) {

    }

    @Override
    public void emergencyShutdown() {

    }

    @Override
    public void openSession(String identifier, String address, int port, long clientID) {
        
    }

    @Override
    public void closeSession(String identifier, String reason) {

    }

    @Override
    public void handleEncapsulated(String identifier, EncapsulatedPacket packet, int flags) {

    }

    @Override
    public void handleRaw(String address, int port, byte[] payload) {

    }

    @Override
    public void notifyACK(String identifier, int identifierACK) {

    }

    @Override
    public void handleOption(String option, String value) {

    }

    /**
     * author: MagicDroidX
     * Nukkit Project
     */
    private class CacheEncapsulatedPacket extends EncapsulatedPacket {

        private byte[] internalData = null;

        @Override
        public byte[] toBinary() {
            return this.toBinary(false);
        }

        @Override
        public byte[] toBinary(boolean internal) {
            if (this.internalData == null) {
                this.internalData = super.toBinary(internal);
            }
            return this.internalData;
        }
    }
}
