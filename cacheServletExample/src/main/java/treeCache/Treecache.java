package treeCache;

import org.jboss.cache.*;

public class Treecache {

    private static TreeCache treeCache;

    public static TreeCache getInstance() {
        if (treeCache == null) {
            initCache();
        }

        return treeCache;
    }

    public static void initCache() {

        try {
            treeCache = new TreeCache();

            PropertyConfigurator config = new PropertyConfigurator(); // configure tree cache. Needs to be in the classpath
            //config.configure(tree, "META-INF/replSync-service.xml");

            treeCache.startService(); // kick start tree cache
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
