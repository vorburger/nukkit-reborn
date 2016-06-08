package org.nukkitmc.nukkitstd.mcpe.v0_14_3.network;

import org.nukkitmc.nukkitstd.minecraft.Slot;

import java.util.UUID;

/**
 * @author Nukkit Project Team
 */
public class CraftingEventPacket extends DataPacket {

    public static final byte NETWORK_ID = ProtocolInfo.CRAFTING_EVENT_PACKET;

    public int windowId;
    public int type;
    public UUID id;

    public Slot[] input;
    public Slot[] output;

    @Override
    public void decode() {
        windowId = getByte();
        type = getInt();
        id = getUUID();

        int inputSize = getInt();
        input = new Slot[inputSize];
        for (int i = 0; i < inputSize && i < 128; ++i) {
            input[i] = getSlot();
        }

        int outputSize = getInt();
        output = new Slot[outputSize];
        for (int i = 0; i < outputSize && i < 128; ++i) {
            output[i] = getSlot();
        }
    }

    @Override
    public void encode() {

    }

    @Override
    public byte pid() {
        return NETWORK_ID;
    }

}
