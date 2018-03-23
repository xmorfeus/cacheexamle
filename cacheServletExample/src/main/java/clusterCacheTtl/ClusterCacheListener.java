package clusterCacheTtl;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ClusterCacheListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        ClusterCache.init();
    }

    public void contextDestroyed(ServletContextEvent sce) {
        ClusterCache.destroy();
    }
}
