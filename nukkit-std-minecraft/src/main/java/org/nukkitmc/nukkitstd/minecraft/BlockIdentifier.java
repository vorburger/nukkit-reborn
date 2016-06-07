package org.nukkitmc.nukkitstd.minecraft;

/**
 * Created by Mulan Lin('Snake1999') on 2016/6/7 9:34.
 */
public interface BlockIdentifier extends ComponentIdentifier {

    String asStringId();

    int asIntegerId();

    int asIntegerMeta();
}
