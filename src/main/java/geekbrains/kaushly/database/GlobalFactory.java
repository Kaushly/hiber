package geekbrains.kaushly.database;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GlobalFactory {

    private static SessionFactory sessionFactory;

    public GlobalFactory(String config){
        sessionFactory = new Configuration()
                .configure(config)
                .buildSessionFactory();
    }

    public static SessionFactory get() {
        return sessionFactory;
    }

    public static void close(){
        sessionFactory.close();
    }
}
