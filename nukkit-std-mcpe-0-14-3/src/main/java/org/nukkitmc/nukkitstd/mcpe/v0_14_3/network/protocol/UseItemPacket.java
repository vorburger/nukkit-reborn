package org.nukkitmc.nukkitstd.mcpe.v0_14_3.network.protocol;

import org.nukkitmc.nukkit.math.BlockVector;
import org.nukkitmc.nukkit.math.EntityVector;
import org.nukkitmc.nukkitstd.minecraft.Slot;

/**
 * @author Nukkit Project Team
 */
public class UseItemPacket extends DataPacket {

    public static final byte NETWORK_ID = ProtocolInfo.USE_ITEM_PACKET;

    /*public int x;
    public int y;
    public int z;*/
    public BlockVector block;

    public int face;

    public float fx;
    public float fy;
    public float fz;

    /*public float posX;
    public float posY;
    public float posZ;*/
    public EntityVector playerVector;

    public int slot;

    public Slot item;

    @Override
    public byte pid() {
        return NETWORK_ID;
    }

    @Override
    public void decode() {
        /*this.x = this.getInt();
        this.y = this.getInt();
        this.z = this.getInt();*/
        this.block = this.getBlockVector();
        this.face = this.getByte();
        this.fx = this.getFloat();
        this.fy = this.getFloat();
        this.fz = this.getFloat(); //// TODO: 2016/6/8 face vectors
        /*this.posX = this.getFloat();
        this.posY = this.getFloat();
        this.posZ = this.getFloat();*/
        this.playerVector = getEntityVector();
        this.slot = this.getInt();
        this.item = this.getSlot();
    }

    @Override
    public void encode() {

    }

}
