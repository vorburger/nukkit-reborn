package org.nukkitmc.nukkitstd.mcpe.v0_14_3.network.protocol;

import org.nukkitmc.nukkit.math.BlockVector;

/**
 * @author Nukkit Project Team
 */
public class SetSpawnPositionPacket extends DataPacket {

    public static final byte NETWORK_ID = ProtocolInfo.SET_SPAWN_POSITION_PACKET;

    /*public int y;
    public int z;
    public int x;*/
    public BlockVector vector;

    @Override
    public void decode() {

    }

    @Override
    public void encode() {
        reset();
        /*putInt(x);
        putInt(y);
        putInt(z);*/
        putBlockVector(vector);
    }

    @Override
    public byte pid() {
        return NETWORK_ID;
    }

}
