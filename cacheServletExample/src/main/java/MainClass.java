import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;


public class MainClass {
    public static void main(String[] args) {

//        Config cfg = new Config();
//        HazelcastInstance instance = Hazelcast.newHazelcastInstance(cfg);
//        Map<Integer, String> mapCustomers = instance.getMap("customers");
//        mapCustomers.put(1, "Joe");
//        mapCustomers.put(2, "Ali");
//        mapCustomers.put(3, "Avi");
//
//        System.out.println("Customer with key 1: "+ mapCustomers.get(1));
//        System.out.println("Map Size:" + mapCustomers.size());
        


        ClientConfig clientConfig = new ClientConfig();
        clientConfig.addAddress("127.0.0.1:5701");
        HazelcastInstance client = HazelcastClient.newHazelcastClient(clientConfig);
        IMap map = client.getMap("objects");
        System.out.println("Map Size:" + map.size());



    }
}
