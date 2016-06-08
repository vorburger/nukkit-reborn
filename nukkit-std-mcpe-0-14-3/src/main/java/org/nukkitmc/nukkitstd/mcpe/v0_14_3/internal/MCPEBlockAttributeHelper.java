package org.nukkitmc.nukkitstd.mcpe.v0_14_3.internal;

import org.nukkitmc.nukkitstd.minecraft.BlockAttribute;
import org.nukkitmc.nukkitstd.minecraft.BlockAttributeMapper;
import org.nukkitmc.nukkitstd.minecraft.BlockIdentifier;
import org.nukkitmc.nukkitstd.minecraft.Tool;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mulan Lin('Snake1999') on 2016/6/7 14:55.
 */
final class MCPEBlockAttributeHelper {
    private static Map<BlockIdentifier, BlockAttribute> attributeMap = new HashMap<BlockIdentifier, BlockAttribute>() {{
        put(ofIdentifier(0, 0), ofAttribute(0, 0, 0, false, true, null)); // Air
        //// TODO: 2016/6/7 add all 0.14.3 blocks
    }};

    static void registerToMapper(BlockAttributeMapper mapper) {
        attributeMap.forEach(mapper::addMappingRule);
    }


    /***** internal part *****/

    private MCPEBlockAttributeHelper() {} // can not have an instance.

    private static BlockAttribute ofAttribute(int blastResistance, int lightness, int hardness,
                                            boolean canBurn, boolean transparent, Tool requiredTool) {
        return MCPEBlockAttribute.of(blastResistance, lightness, hardness, canBurn, transparent, requiredTool);
    }
    private static BlockIdentifier ofIdentifier(int id, int meta) {
        return new MCPEBlockIdentifier(id, meta);
    }

    private static class MCPEBlockAttribute implements BlockAttribute {

        static MCPEBlockAttribute of(int blastResistance, int lightness, int hardness,
                                     boolean canBurn, boolean transparent, Tool requiredTool) {
            MCPEBlockAttribute ans = new MCPEBlockAttribute();
            ans.lightness = lightness;
            ans.hardness = hardness;
            ans.canBurn = canBurn;
            ans.transparent = transparent;
            ans.requiredTool = requiredTool;
            ans.blastResistance = blastResistance;
            return ans;
        }

        int blastResistance;
        int lightness;
        int hardness;
        boolean canBurn;
        boolean transparent;
        Tool requiredTool;

        private MCPEBlockAttribute(){}

        @Override
        public int getBlastResistance() {return blastResistance;}

        @Override
        public int getLightness() {return lightness;}

        @Override
        public int getHardness() {return hardness;}

        @Override
        public boolean canBurn() {return canBurn;}

        @Override
        public boolean isTransparent() {return transparent;}

        @Override
        public Tool getRequiredTool() {return requiredTool;}
    }
}
