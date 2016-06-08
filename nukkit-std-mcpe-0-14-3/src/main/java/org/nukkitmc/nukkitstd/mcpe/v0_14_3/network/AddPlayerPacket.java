package org.nukkitmc.nukkitstd.mcpe.v0_14_3.network;

//import cn.nukkit.entity.data.EntityMetadata;
import cn.nukkit.utils.Binary;
import org.nukkitmc.nukkit.math.EntityVector;
import org.nukkitmc.nukkit.math.HeadedEntityRotation;
import org.nukkitmc.nukkit.math.Velocity;
import org.nukkitmc.nukkitstd.minecraft.Slot;

import java.util.UUID;

/**
 * author: MagicDroidX
 * Nukkit Project
 */
public class AddPlayerPacket extends DataPacket {
    public static final byte NETWORK_ID = ProtocolInfo.ADD_PLAYER_PACKET;

    @Override
    public byte pid() {
        return NETWORK_ID;
    }

    // TODO: 2016/6/8 getters and setters

    public UUID uuid;
    public String username;
    public long eid;
               /* OLD CODE USED HERE BEFORE
                public float x;
                public float y;
                public float z;
                public float speedX;
                public float speedY;
                public float speedZ;
                public float pitch;
                public float yaw;*/
    public EntityVector position;
    public Velocity velocity;
    public HeadedEntityRotation rotation;
    protected Slot item;
    //todo public EntityMetadata metadata;

    @Override
    public void decode() {

    }

    @Override
    public void encode() {
        this.reset();
        this.putUUID(uuid);
        this.putString(username);
        this.putLong(eid);
                        /* OLD CODE USED HERE BEFORE
                        this.putFloat(this.x);
                        this.putFloat(this.y);
                        this.putFloat(this.z);
                        this.putFloat(this.speedX);
                        this.putFloat(this.speedY);
                        this.putFloat(this.speedZ);
                        this.putFloat(this.yaw);
                        this.putFloat(this.yaw); //headrot
                        this.putFloat(this.pitch);*/
        this.putEntityVector(position);
        this.putVelocity(velocity);
        this.putHeadedEntityRotation(rotation);
        this.putSlot(item);
        //todo this.put(Binary.writeMetadata(this.metadata));
    }
}
