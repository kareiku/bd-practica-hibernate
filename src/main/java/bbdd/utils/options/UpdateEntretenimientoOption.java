package bbdd.utils.options;

import bbdd.model.Entretenimiento;
import org.hibernate.Session;

public class UpdateEntretenimientoOption extends Option {
    public void execute(Session session) {
        Entretenimiento entretenimiento = session.load(Entretenimiento.class, 9L);
        entretenimiento.setNombre("Starfruit farming");
        session.update(entretenimiento);
    }
}
