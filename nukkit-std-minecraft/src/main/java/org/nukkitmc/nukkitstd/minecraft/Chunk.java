package org.nukkitmc.nukkitstd.minecraft;

/**
 * Created by Mulan Lin('Snake1999') on 2016/6/7 10:07.
 */
public interface Chunk {

    BlockIdentifier getBlockAt(int x, int z);

    void setBlockAt(int x, int z, BlockIdentifier id);


}
