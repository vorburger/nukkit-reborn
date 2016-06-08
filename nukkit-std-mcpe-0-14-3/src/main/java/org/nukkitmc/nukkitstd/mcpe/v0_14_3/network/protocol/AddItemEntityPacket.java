package org.nukkitmc.nukkitstd.mcpe.v0_14_3.network.protocol;

import org.nukkitmc.nukkit.math.EntityVector;
import org.nukkitmc.nukkit.math.Velocity;
import org.nukkitmc.nukkitstd.minecraft.Slot;

/**
 * author: MagicDroidX
 * Nukkit Project
 */
public class AddItemEntityPacket extends DataPacket {
    public static final byte NETWORK_ID = ProtocolInfo.ADD_ITEM_ENTITY_PACKET;

    @Override
    public byte pid() {
        return NETWORK_ID;
    }

    public long eid;
    public Slot item;
    /*public float x;
    public float y;
    public float z;
    public float speedX;
    public float speedY;
    public float speedZ;*/
    public EntityVector position;
    public Velocity velocity;

    @Override
    public void decode() {

    }

    @Override
    public void encode() {
        this.reset();
        this.putLong(this.eid);
        this.putSlot(this.item);
        /*this.putFloat(this.x);
        this.putFloat(this.y);
        this.putFloat(this.z);
        this.putFloat(this.speedX);
        this.putFloat(this.speedY);
        this.putFloat(this.speedZ);*/
        this.putEntityVector(position);
        this.putVelocity(velocity);
    }
}
