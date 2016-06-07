package org.nukkitmc.nukkitstd.minecraft;

/**
 * Created by Mulan Lin('Snake1999') on 2016/6/7 14:43.
 */
public interface BlockAttributeMapper {

    BlockAttribute getBlockAttribute(BlockIdentifier identifier);

    void addMappingRule(BlockIdentifier identifier, BlockAttribute attribute);
}
