package bbdd.utils.options;

import bbdd.model.Pasajero;
import org.hibernate.Session;

public class DeletePasajeroOption implements Option {
    public void execute(Session session) {
        Pasajero pasajero = session.load(Pasajero.class, 4L);
        session.beginTransaction();
        session.delete(pasajero);
        session.getTransaction().commit();
    }
}
