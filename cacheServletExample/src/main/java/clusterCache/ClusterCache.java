package clusterCache;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

import java.util.Map;

public class ClusterCache {

    private static HazelcastInstance instance;

    public static void init() {
        Config cfg = new Config();
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
