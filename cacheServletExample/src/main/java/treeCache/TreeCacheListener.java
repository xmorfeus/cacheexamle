package treeCache;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class TreeCacheListener  implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        Treecache.initCache();
    }

    public void contextDestroyed(ServletContextEvent sce) {

    }
}

