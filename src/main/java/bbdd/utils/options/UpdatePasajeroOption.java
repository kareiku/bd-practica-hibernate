package bbdd.utils.options;

import bbdd.model.Pasajero;
import org.hibernate.Session;

public class UpdatePasajeroOption extends Option {
    public void execute(Session session) {
        Pasajero pasajero = session.load(Pasajero.class, 7L);
        pasajero.setNombre("Mortarion");
        session.update(pasajero);
    }
}
