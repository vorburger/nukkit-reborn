package org.nukkitmc.nukkitstd.mcpe.v0_14_3.network.protocol;

import org.nukkitmc.nukkit.math.EntityVector;

/**
 * @author Nukkit Project Team
 */
public class RespawnPacket extends DataPacket {

    public static final byte NETWORK_ID = ProtocolInfo.RESPAWN_PACKET;

    /*public float x;
    public float y;
    public float z;*/
    public EntityVector vector;

    @Override
    public void decode() {
        /*this.x = getFloat();
        this.y = getFloat();
        this.z = getFloat();*/
        this.vector = getEntityVector();
    }

    @Override
    public void encode() {
        this.reset();
        /*this.putFloat(this.x);
        this.putFloat(this.y);
        this.putFloat(this.z);*/
        this.putEntityVector(vector);
    }

    @Override
    public byte pid() {
        return NETWORK_ID;
    }

}
