package org.nukkitmc.nukkitstd.mcpe.v0_14_3.network;

/**
 * author: MagicDroidX
 * Nukkit Project
 */
public class ChunkRadiusUpdatePacket extends DataPacket {

    public static final byte NETWORK_ID = ProtocolInfo.CHUNK_RADIUS_UPDATE_PACKET;

    public int radius;

    @Override
    public void decode() {
    }

    @Override
    public void encode() {
        super.reset();
        this.putInt(this.radius);
    }

    @Override
    public byte pid() {
        return NETWORK_ID;
    }

}
