package bbdd.utils.options;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public abstract class Option {
    public void tryExecution(SessionFactory factory) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            this.execute(session);
            session.getTransaction().commit();
        } catch (Exception ex) {
            assert false : ex.getMessage();
        }
    }

    protected abstract void execute(Session session);
}
