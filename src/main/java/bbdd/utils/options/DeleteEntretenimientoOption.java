package bbdd.utils.options;

import bbdd.model.Entretenimiento;
import org.hibernate.Session;

public class DeleteEntretenimientoOption implements Option {
    public void execute(Session session) {
        Entretenimiento entretenimiento = session.load(Entretenimiento.class, 4L);
        session.beginTransaction();
        session.delete(entretenimiento);
        session.getTransaction().commit();
    }
}
