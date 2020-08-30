package my.experiments.database.hibernate.util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateSessionFactorUtil {

    public static SessionFactory getSessionFactory() {
//        Configuration configuration = new Configuration().configure();
//        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
//                .applySettings(configuration.getProperties());
//        SessionFactory sessionFactory = configuration
//                .buildSessionFactory(builder.build());
//        return sessionFactory;
        Configuration configuration = new Configuration();
        SessionFactory sessionFactory = null;

        try {

            configuration.configure("hibernate.cfg.xml");
            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        } catch (HibernateException ex) {
            System.out.println("ERROR: Init SessionFactory creation failed: " + ex);
        }

        return sessionFactory;
    }
}
