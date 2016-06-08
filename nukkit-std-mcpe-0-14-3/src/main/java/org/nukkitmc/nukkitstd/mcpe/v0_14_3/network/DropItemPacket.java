package org.nukkitmc.nukkitstd.mcpe.v0_14_3.network;

import org.nukkitmc.nukkitstd.minecraft.Slot;

/**
 * @author Nukkit Project Team
 */
public class DropItemPacket extends DataPacket {

    public static final byte NETWORK_ID = ProtocolInfo.DROP_ITEM_PACKET;

    public int type;
    public Slot item;

    @Override
    public void decode() {
        type = getByte();
        item = getSlot();
    }

    @Override
    public void encode() {

    }

    @Override
    public byte pid() {
        return NETWORK_ID;
    }

}
