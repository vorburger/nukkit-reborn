package org.nukkitmc.nukkitstd.mcpe.v0_14_3.internal;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * Created by Mulan Lin('Snake1999') on 2016/6/7 12:35.
 */
public class Activator implements BundleActivator {

    private MapperServiceTracker mapperServiceTracker;

    @Override
    public void start(BundleContext context) throws Exception {
        mapperServiceTracker = new MapperServiceTracker(context);
        mapperServiceTracker.open();
        MCPEBlockAttributeHelper.registerToMapper(mapperServiceTracker.getService());
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        if (mapperServiceTracker != null) mapperServiceTracker.close();
    }
}
