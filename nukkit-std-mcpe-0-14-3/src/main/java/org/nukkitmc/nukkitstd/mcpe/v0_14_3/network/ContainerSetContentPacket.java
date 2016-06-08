package org.nukkitmc.nukkitstd.mcpe.v0_14_3.network;

import org.nukkitmc.nukkitstd.minecraft.Slot;

/**
 * author: MagicDroidX
 * Nukkit Project
 */
public class ContainerSetContentPacket extends DataPacket {
    public static final byte NETWORK_ID = ProtocolInfo.CONTAINER_SET_CONTENT_PACKET;

    @Override
    public byte pid() {
        return NETWORK_ID;
    }

    public static final byte SPECIAL_INVENTORY = 0;
    public static final byte SPECIAL_ARMOR = 0x78;
    public static final byte SPECIAL_CREATIVE = 0x79;
    public static final byte SPECIAL_CRAFTING = 0x7a;

    public int windowid;
    public Slot[] slots = new Slot[0];
    public int[] hotbar = new int[0];

    @Override
    protected void onClean() {
        this.slots = new Slot[0];
        this.hotbar = new int[0];
    }

    @Override
    public void decode() {
        this.windowid = this.getByte();
        int count = this.getShort();
        this.slots = new Slot[count];

        for (int s = 0; s < count && !this.feof(); ++s) {
            this.slots[s] = this.getSlot();
        }

        if (this.windowid == SPECIAL_INVENTORY) {
            count = this.getShort();
            this.hotbar = new int[count];
            for (int s = 0; s < count && !this.feof(); ++s) {
                this.hotbar[s] = this.getInt();
            }
        }
    }

    @Override
    public void encode() {
        this.reset();
        this.putByte((byte) this.windowid);
        this.putShort(this.slots.length);
        for (Slot slot : this.slots) {
            this.putSlot(slot);
        }

        if (this.windowid == SPECIAL_INVENTORY && this.hotbar.length > 0) {
            this.putShort(this.hotbar.length);
            for (int slot : this.hotbar) {
                this.putInt(slot);
            }
        } else {
            this.putShort(0);
        }
    }

    @Override
    public ContainerSetContentPacket clone() {
        ContainerSetContentPacket pk = (ContainerSetContentPacket) super.clone();
        pk.slots = this.slots.clone();
        return pk;
    }
}
