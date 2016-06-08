package org.nukkitmc.nukkitstd.mcpe.v0_14_3.network.protocol;

import org.nukkitmc.nukkit.math.Velocity;

/**
 * author: MagicDroidX
 * Nukkit Project
 */
public class SetEntityMotionPacket extends DataPacket {
    public static final byte NETWORK_ID = ProtocolInfo.SET_ENTITY_MOTION_PACKET;

    // eid, motX, motY, motZ
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
            this.putLong(entry.entityId);
            /*this.putFloat((float) entry.motionX);
            this.putFloat((float) entry.motionY);
            this.putFloat((float) entry.motionZ);*/
            this.putVelocity(entry.velocity);
        }
    }

    public static class Entry {
        public long entityId;
        private Velocity velocity;
        /*public double motionX;
        public double motionY;
        public double motionZ;*/

        //public Entry(long entityId, double motionX, double motionY, double motionZ) {
        public Entry(long entityId, Velocity velocity) {
            this.entityId = entityId;
            /*this.motionX = motionX;
            this.motionY = motionY;
            this.motionZ = motionZ;*/
            this.velocity = velocity;
        }
    }

}
