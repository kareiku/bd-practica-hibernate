package bbdd.utils.options;

import bbdd.model.Pasajero;
import org.hibernate.Session;

public class DeletePasajeroOption extends Option {
    public void execute(Session session) {
        Pasajero pasajero = session.load(Pasajero.class, 4L);
        session.delete(pasajero);
    }
}
