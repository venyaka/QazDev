//package mainApplication;
//
////import org.hibernate.Session;
////import org.hibernate.SessionFactory;
////import org.hibernate.cfg.Configuration;
////import org.springframework.context.annotation.Configuration;
//
////import jakarta.websocket.Session;
////
////import javax.security.auth.login.Configuration;
////import jakarta.websocket.Session
//
//
////import jakarta.websocket.Session;
//
//public class test {
//    public static void main(String[] args) {
//        SessionFactory factory = new Configuration()
//                .configure("hibernate.cfg.xml")
////                .addAnnotatedClass(Database.class)
//                .buildSessionFactory();
//
//        try {
//            Session session = factory.getCurrentSession();
//            Database database = new Database("Venya", "salam");
//            session.beginTransaction();
//            session.save(database);
//            session.getTransaction().commit();
//        }
//        finally {
//            factory.close();
//        }
//    }
//}
