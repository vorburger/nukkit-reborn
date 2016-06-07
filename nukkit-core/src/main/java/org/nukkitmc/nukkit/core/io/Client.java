package org.nukkitmc.nukkit.core.io;

import org.nukkitmc.nukkit.core.gaming.Chunk;
import org.nukkitmc.nukkit.math.ChunkVector;

/**
 * Created by Mulan Lin('Snake1999') on 2016/6/7 10:16.
 */
public interface Client {

    void sendMessage(String message);
    void sendTranslation(String translation);
    void sendTip(String tip);
    void sendPopup(String popup);
    void close(String reason);

    void sendChunk(ChunkVector chunkVector, Chunk chunk);

    //void sendEntitySpawn();
    //void sendPlayerSpawn();
    //...
}
