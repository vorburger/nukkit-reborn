package org.nukkitmc.nukkitstd.rak;

import cn.nukkit.utils.BinaryStream;
import org.nukkitmc.nukkit.core.io.ClientSendable;

/**
 * Created by Mulan Lin('Snake1999') on 2016/6/8 7:16.
 */
public abstract class DataPacket extends BinaryStream implements ClientSendable {
    protected abstract void pid();
    protected abstract void encode();
    protected abstract void decode();

}
