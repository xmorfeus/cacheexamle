package treeCacheTtl;

import org.jboss.cache.Fqn;
import org.jboss.cache.PropertyConfigurator;
import org.jboss.cache.TreeCache;
import org.jboss.cache.eviction.EvictionConfiguration;
import org.jboss.cache.eviction.LRUConfiguration;
import org.jboss.cache.eviction.LRUPolicy;

import javax.servlet.ServletContext;

public class Treecache {

    private static TreeCache treeCache;

    public static TreeCache getInstance() {
//        if (treeCache == null) {
//            initCache();
//        }

        return treeCache;
    }

    public static void initCache(ServletContext sc) {

        try {
            treeCache = new TreeCache();
            treeCache.setInitialStateRetrievalTimeout(10);

//            org.jboss.cache.eviction.RegionManager regionManager = treeCache.getEvictionRegionManager();
//            org.jboss.cache.eviction.Region region = regionManager.getRegion();
//
//            EvictionConfiguration config = region.getEvictionConfiguration();
//            ((LRUConfiguration)config).setMaxNodes(12345);
//            ((LRUConfiguration)config).setTimeToLiveSeconds(5);
//            ((LRUConfiguration)config).setMaxAgeSeconds(5);
            PropertyConfigurator config = new PropertyConfigurator(); // configure tree cache. Needs to be in the classpath
            config.configure(treeCache, "C://treecache.xml");

            treeCache.startService(); // kick start tree cache
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
