package org.nukkitmc.nukkitstd.mcpe.v0_14_3.network;

import org.nukkitmc.nukkit.math.EntityVector;
import org.nukkitmc.nukkit.math.HeadedEntityRotation;

/**
 * author: MagicDroidX
 * Nukkit Project
 */
public class MoveEntityPacket extends DataPacket {
    public static final byte NETWORK_ID = ProtocolInfo.MOVE_ENTITY_PACKET;

    // eid, x, y, z, yaw, pitch
    public Entry[] entries = new Entry[0];

    @Override
    public byte pid() {
        return NETWORK_ID;
    }

    @Override
    protected void onClean() {
        this.entries = new Entry[0];
    }

    @Override
    public void decode() {

    }

    @Override
    public void encode() {
        this.reset();
        this.putInt(this.entries.length);
        for (Entry entry : this.entries) {
            this.putLong(entry.eid);
            /*this.putFloat((float) entry.x);
            this.putFloat((float) entry.y);
            this.putFloat((float) entry.z);
            this.putFloat((float) entry.yaw);
            this.putFloat((float) entry.headyaw);
            this.putFloat((float) entry.pitch);*/
            this.putEntityVector(entry.vector);
            this.putHeadedEntityRotation(entry.rotation);
        }
    }

    public static class Entry {
        public long eid;
        /*
        public double x;
        public double y;
        public double z;
        public double yaw;
        public double headyaw;
        public double pitch;
        */
        public EntityVector vector;
        public HeadedEntityRotation rotation;

        //public Entry(long eid, double x, double y, double z, double yaw, double headyaw, double pitch) {
        public Entry(long eid, EntityVector vector, HeadedEntityRotation rotation) {
            this.eid = eid;
            /*this.x = x;
            this.y = y;
            this.z = z;
            this.yaw = yaw;
            this.headyaw = headyaw;
            this.pitch = pitch;
            */
            this.vector = vector;
            this.rotation = rotation;
        }
    }
}
