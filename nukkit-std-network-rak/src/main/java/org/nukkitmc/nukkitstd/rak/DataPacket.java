package org.nukkitmc.nukkitstd.rak;

import cn.nukkit.raknet.protocol.EncapsulatedPacket;
import cn.nukkit.utils.BinaryStream;

/**
 * author: MagicDroidX
 * Nukkit Project
 */
public abstract class DataPacket extends BinaryStream implements Cloneable {

    private boolean encoded = false;

    public abstract byte pid();

    public abstract void decode();

    public abstract void encode();

    @Override
    public final void reset() {
        super.reset();
        this.putByte(this.pid());
    }

    protected final DataPacket clean() {
        this.setBuffer(null);
        this.encoded = false;
        this.offset = 0;
        this.onClean();
        return this;
    }

    protected void onClean() {}

    @Override
    public DataPacket clone() {
        try {
            return (DataPacket) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

}
