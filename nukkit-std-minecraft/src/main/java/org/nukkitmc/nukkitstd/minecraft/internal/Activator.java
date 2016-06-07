package org.nukkitmc.nukkitstd.minecraft.internal;

import org.nukkitmc.nukkitstd.minecraft.BlockAttributeMapper;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import java.util.Hashtable;

/**
 * Created by Mulan Lin('Snake1999') on 2016/6/7 14:53.
 */
public class Activator implements BundleActivator {
    private ServiceRegistration mapperRegistration;
    @Override
    public void start(BundleContext context) throws Exception {
        mapperRegistration = context.registerService(BlockAttributeMapper.class, new SimpleBlockAttributeMapper(), new Hashtable<>());
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        mapperRegistration.unregister();
    }
}
