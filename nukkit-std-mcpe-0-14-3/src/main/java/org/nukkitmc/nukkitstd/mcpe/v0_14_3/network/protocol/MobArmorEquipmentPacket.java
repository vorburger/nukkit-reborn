package org.nukkitmc.nukkitstd.mcpe.v0_14_3.network.protocol;

import org.nukkitmc.nukkitstd.minecraft.Slot;

/**
 * author: MagicDroidX
 * Nukkit Project
 */
public class MobArmorEquipmentPacket extends DataPacket {
    public static final byte NETWORK_ID = ProtocolInfo.MOB_ARMOR_EQUIPMENT_PACKET;

    @Override
    public byte pid() {
        return NETWORK_ID;
    }

    public long eid;
    public Slot[] slots = new Slot[4];

    @Override
    public void decode() {
        this.eid = this.getLong();
        this.slots = new Slot[4];
        this.slots[0] = this.getSlot();
        this.slots[1] = this.getSlot();
        this.slots[2] = this.getSlot();
        this.slots[3] = this.getSlot();
    }

    @Override
    public void encode() {
        this.reset();
        this.putLong(this.eid);
        this.putSlot(this.slots[0]);
        this.putSlot(this.slots[1]);
        this.putSlot(this.slots[2]);
        this.putSlot(this.slots[3]);
    }
}
