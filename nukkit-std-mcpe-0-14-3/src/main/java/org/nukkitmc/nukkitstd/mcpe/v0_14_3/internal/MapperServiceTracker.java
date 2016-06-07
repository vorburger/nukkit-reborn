package org.nukkitmc.nukkitstd.mcpe.v0_14_3.internal;

import org.nukkitmc.nukkitstd.minecraft.BlockAttributeMapper;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

/**
 * Created by Mulan Lin('Snake1999') on 2016/6/7 15:11.
 */
class MapperServiceTracker extends ServiceTracker<BlockAttributeMapper, BlockAttributeMapper>{
    public MapperServiceTracker(BundleContext context) {
        super(context, BlockAttributeMapper.class, null);
    }
}
