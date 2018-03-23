package clusterCacheTtl;

import com.hazelcast.config.Config;
import com.hazelcast.config.FileSystemXmlConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

import java.io.File;
import java.io.FileNotFoundException;

public class ClusterCache {

    private static HazelcastInstance instance;

    public static void init() {
        Config cfg = new Config();

        try {
            cfg = new FileSystemXmlConfig(new File("C://hazelcast.xml"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        instance = Hazelcast.newHazelcastInstance(cfg);
    }

    public static void destroy() {
        instance.shutdown();
    }

    public static HazelcastInstance getInstance() {

        if (instance == null) {
            init();
        }

        return instance;
    }
}
