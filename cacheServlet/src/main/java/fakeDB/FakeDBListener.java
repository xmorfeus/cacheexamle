package fakeDB;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Timer;
import java.util.TimerTask;

public class FakeDBListener implements ServletContextListener {

    private Timer t;
    private TimerTask task;

    public void contextInitialized(ServletContextEvent sce) {
                t = new Timer();
        task = new TimerTask() {
            @Override
            public void run() {

                FakeDB.changeObject();

            }
        } ;

        t.scheduleAtFixedRate(task , 5000, 5000 );
    }

    public void contextDestroyed(ServletContextEvent sce) {
    }
}