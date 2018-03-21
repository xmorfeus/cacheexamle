package cz.B6B36NSS.treecache;

import org.jboss.cache.PropertyConfigurator;
import org.jboss.cache.TreeCache;

public class JBossCache {
	private static String lock = "LOCK";
    private static JBossCache instance = null;
    private static TreeCache cache = null;
    public static final String DEFAULT_FILE_NAME = "treecache.xml";
    public static final String SYSTEM_JBOSS_CONFIGURATION = "jboss.configuration";
    private static String configFileName = null;
    
    private JBossCache() {
        init();
    }
    
    public static JBossCache getInstance() {
        if ( instance == null ) {
            synchronized(lock) {
                if ( instance == null ) {
                    instance = new JBossCache();
                }
            }
        }
        return instance;
    }
    
    public static void setInstance(JBossCache newInstance) {
        instance = newInstance;
    }
    
    public void init() {
        try {
            if ( cache != null ) {
                cache.stopService();
            }
            cache = new TreeCache();
            PropertyConfigurator config = new PropertyConfigurator();
            config.configure(cache, getInitConfigFileName() );
            cache.startService();
        } catch (Exception e) {
        	e.printStackTrace();
            //logger.error("JBoss tree cache init ERROR !!! ", e);
        }
    }
    
    public static String getInitConfigFileName() {
    	if (configFileName == null) {
    		configFileName = getSystemJbossFileName();
    		if (configFileName == null) {
    			configFileName = DEFAULT_FILE_NAME;
    		}
    	}
    	return configFileName;
    }
    
    public static String getConfigFileName() {
        return configFileName;
    }
    
    private static String getSystemJbossFileName() {
		return System.getProperty(SYSTEM_JBOSS_CONFIGURATION);
	}

	public static void setConfigFileName(String configFileName) {
        JBossCache.configFileName = configFileName;
    }
	
	public TreeCache getCache() {
        return cache;
    }

    public void setCache(TreeCache cache) {
        JBossCache.cache = cache;
    }
}
