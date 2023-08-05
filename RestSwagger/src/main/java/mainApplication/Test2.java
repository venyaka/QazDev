package mainApplication;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public void add(String sequence) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Database.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            Database database = new Database(sequence);
            session.beginTransaction();
            session.save(database);
            session.getTransaction().commit();
        }
        finally {
            factory.close();
        }
    }
}
