package bbdd.utils.options;

import bbdd.model.Entretenimiento;
import org.hibernate.Session;

public class UpdateEntretenimientoOption implements Option {
    public void execute(Session session) {
        Entretenimiento entretenimiento = session.load(Entretenimiento.class, 9L);
        entretenimiento.setNombre("Starfruit farming");
        session.beginTransaction();
        session.update(entretenimiento);
        session.getTransaction().commit();
    }
}
