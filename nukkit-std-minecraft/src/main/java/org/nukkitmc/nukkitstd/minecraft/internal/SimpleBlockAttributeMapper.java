package org.nukkitmc.nukkitstd.minecraft.internal;

import org.nukkitmc.nukkitstd.minecraft.BlockAttribute;
import org.nukkitmc.nukkitstd.minecraft.BlockAttributeMapper;
import org.nukkitmc.nukkitstd.minecraft.BlockIdentifier;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mulan Lin('Snake1999') on 2016/6/7 14:45.
 */
class SimpleBlockAttributeMapper implements BlockAttributeMapper {

    @Override
    public BlockAttribute getBlockAttribute(BlockIdentifier identifier) {
        return stringIdToAttribute.getOrDefault(identifier,
                intIdMetaToAttribute.getOrDefault(makeNode(identifier),
                        intIdMetaToAttribute.getOrDefault(identifier.asIntegerId(),
                                null)));
    }

    @Override
    public void addMappingRule(BlockIdentifier identifier, BlockAttribute attribute) {
        if (identifier.asStringId() != null) stringIdToAttribute.put(identifier.asStringId(), attribute);
        intIdMetaToAttribute.put(makeNode(identifier), attribute);
        if (identifier.asIntegerMeta() == 0) intIdToAttribute.put(identifier.asIntegerId(), attribute);
    }

    /** INTERNAL PART **/

    private class NodeIdMeta{
        int id, meta;
    }
    private NodeIdMeta makeNode(int id, int meta) {
        NodeIdMeta node = new NodeIdMeta();
        node.id = id;
        node.meta = meta;
        return node;
    }
    private NodeIdMeta makeNode(BlockIdentifier identifier) {
        return makeNode(identifier.asIntegerId(), identifier.asIntegerMeta());
    }
    private Map<NodeIdMeta, BlockAttribute> intIdMetaToAttribute = new HashMap<>();
    private Map<Integer, BlockAttribute> intIdToAttribute = new HashMap<>();
    private Map<String, BlockAttribute> stringIdToAttribute = new HashMap<>();

}
