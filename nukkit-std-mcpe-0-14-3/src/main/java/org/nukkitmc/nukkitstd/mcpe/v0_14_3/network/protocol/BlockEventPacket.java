package org.nukkitmc.nukkitstd.mcpe.v0_14_3.network.protocol;

import org.nukkitmc.nukkit.math.BlockVector;

/**
 * author: MagicDroidX
 * Nukkit Project
 */
public class BlockEventPacket extends DataPacket {
    public static final byte NETWORK_ID = ProtocolInfo.BLOCK_EVENT_PACKET;

    @Override
    public byte pid() {
        return NETWORK_ID;
    }

    /*public int x;
    public int y;
    public int z;*/
    public BlockVector vector;
    public int case1;
    public int case2;

    @Override
    public void decode() {

    }

    @Override
    public void encode() {
        this.reset();
        /*this.putInt(this.x);
        this.putInt(this.y);
        this.putInt(this.z);*/
        this.putBlockVector(vector);
        this.putInt(this.case1);
        this.putInt(this.case2);
    }
}
