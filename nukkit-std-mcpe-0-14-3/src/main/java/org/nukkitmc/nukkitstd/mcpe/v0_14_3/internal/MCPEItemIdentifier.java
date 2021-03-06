package org.nukkitmc.nukkitstd.mcpe.v0_14_3.internal;

import org.nukkitmc.nukkitstd.minecraft.ItemIdentifier;

/**
 * Created by Mulan Lin('Snake1999') on 2016/6/7 12:17.
 */
public class MCPEItemIdentifier implements ItemIdentifier {

    private int intId;
    private int intMeta;

    public MCPEItemIdentifier(int intId, int intMeta){
        this.intId = intId;
        this.intMeta = intMeta;
    }

    @Override
    public String asStringId() {
        //Minecraft PE does not use string id at present.
        return null;
    }

    @Override
    public int asIntegerId() {
        return intId;
    }

    @Override
    public int asIntegerMeta() {
        return intMeta;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof MCPEItemIdentifier)) return false;
        MCPEItemIdentifier identifier = (MCPEItemIdentifier) obj;
        return identifier.asIntegerId() == this.asIntegerId() && identifier.asIntegerMeta() == this.asIntegerMeta();
    }
}