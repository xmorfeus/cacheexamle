package cz.B6B36NSS.treecache;

import org.jboss.cache.CacheException;

import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;

public class JBossListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent event) {
//        JBossCacheManager.cleanCacheTree();
    }

    public void contextDestroyed(ServletContextEvent event) {
        try {
            JBossCache.getInstance().getCache().remove("/");
        } catch (CacheException e) {
            //org.apache.log4j.Logger.getLogger(this.getClass()).info("", e);
        }
//        JBossCacheManager.cleanCacheTree();
    }
}
